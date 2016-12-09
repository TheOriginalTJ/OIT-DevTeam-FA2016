package OIT_Dev;

import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time
{
	/**
	 * A regular expression for capturing and matching the days in a week-string
	 */
	public static final String WEEK_FORMAT = "^(?<sunday>[Ss-]?)" + "(?<monday>[Mm-]?)" 
			+ "(?<tuesday>[Tt-]?)" + "(?<wednesday>[Ww-]?)" + "(?<thursday>[Rr-]?)" 
				+ "(?<friday>[Ff-]?)" + "(?<saturday>[Ss-]?)$";

	/**
	 * Gets the equivalent block index for a specified start time. End time is
	 * assumed to be 10 minutes after the start time. <br>
	 * Note: an integer with a leading zero is interpreted as an octal (base 8)
	 * integer.
	 * 
	 * @param time
	 *          the time, as an integer, in military time, with no leading zeroes,
	 *          between 800 and 2000.
	 * @return the corresponding block index
	 */
	private static int getBlock(int time)
	{
		// Remove remainder
		time = time - (time % 10);

		if (time < 800 | time > 2000)
		{
			// Invalid time format
			return -1;
		}
		time = time - 800;

		// Trim, but not round
		time = time / 10;

		int b = 0;

		int hour = time / 10;
		int min = time % 10;
		b = (hour * 6) + min;

		return b;

	}

	/**
	 * Transforms a specified week_string, start time, and end time into an array
	 * of 7 72-bit BitSets.
	 * 
	 * @param week_string
	 *          A string that is accepted by the regular expression
	 *          '[Ss-]?[Mm-]?[Tt-]?[Ww-]?[Rr-]?[Ff-]?[Ss-]?', which cannot only
	 *          contain either an 'S' or an 's'.
	 * @param start
	 *          a start time, as an integer between 800 and 2000.
	 * @param end
	 *          an end time, as an integer between 800 and 2000.
	 * @return an array of 7 72-bit BitSets.
	 */
	private static BitSet[] toBitSetArray(String week_string, int start, int end)
	{
		boolean[] days = new boolean[7];

		BitSet[] output = new BitSet[7];

		// Matches the pattern. -------, SMTWRFS, or smtwrfs, or cross between.
		boolean format_correctness = week_string.matches(WEEK_FORMAT);

		// If string contains a weekend, it must contain at least one other thing.
		boolean not_just_single_weekend = week_string.matches("^(([^Ss]*)|(.+?[Ss])|([Ss].+))$");
		if (format_correctness && not_just_single_weekend)
		{
			Matcher m = Pattern.compile(WEEK_FORMAT).matcher(week_string);
			m.matches();
			days[0] = m.group("sunday").matches("[Ss]");
			days[1] = m.group("monday").matches("[Mm]");
			days[2] = m.group("tuesday").matches("[Tt]");
			days[3] = m.group("wednesday").matches("[Ww]");
			days[4] = m.group("thursday").matches("[Rr]");
			days[5] = m.group("friday").matches("[Ff]");
			days[6] = m.group("saturday").matches("[Ss]");

			for (int i = 0; i < 7; i++)
			{
				output[i] = new BitSet(72);
				if (days[i])
				{
					// Add day
					for (int j = 0; j < 72; j++)
					{
						if (j >= getBlock(start) && j < getBlock(end))
						{
							output[i].set(j);
						} else
						{
							output[i].clear(j);
						}
					}
				} else
				{
					for (int j = 0; j < 72; j++)
					{
						output[i].clear(j);
					}
				}
				// System.out.println("" + i + ": " + output[i].cardinality());
			}

			return output;
		} else
		{
			// Throw error?
			// System.out.println("error");
			return null;
		}
	}

	private BitSet[] week = new BitSet[7];

	/**
	 * A class representing the schedule for a room or a professor, for an entire
	 * week.
	 */
	public Time()
	{
		for (int i = 0; i < 7; i++)
		{
			week[i] = new BitSet(72);
			for (int j = 0; j < 72; j++)
			{
				week[i].set(j);
				week[i].clear(j);
			}
		}
	}

	/**
	 * Verify that the provided week_string, start time, and end time are in the
	 * correct format.
	 * 
	 * @param week_string
	 *          A string that is accepted by the regular expression
	 *          '[Ss-]?[Mm-]?[Tt-]?[Ww-]?[Rr-]?[Ff-]?[Ss-]?', which cannot only
	 *          contain either an 'S' or an 's'.
	 * @param start
	 *          a start time, as an integer between 800 and 2000.
	 * @param end
	 *          an end time, as an integer between 800 and 2000.
	 * @return true, if in the correct format.
	 */
	public boolean validateCourse(String week_string, int start, int end)
	{
		BitSet[] sets = toBitSetArray(week_string, start, end);
		// System.out.println(sets != null);
		return (sets != null);
	}

	/**
	 * Check if a class could be added without conflict.
	 * 
	 * @param week_string
	 *          A string that is accepted by the regular expression
	 *          '[Ss-]?[Mm-]?[Tt-]?[Ww-]?[Rr-]?[Ff-]?[Ss-]?', which cannot only
	 *          contain either an 'S' or an 's'.
	 * @param start
	 *          a start time, as an integer between 800 and 2000.
	 * @param end
	 *          an end time, as an integer between 800 and 2000.
	 * @return true, if it may be added.
	 */
	public boolean testCourse(String week_string, int start, int end)
	{
		BitSet[] course = toBitSetArray(week_string, start, end);
		if (null == course)
		{
			// Error
			System.err.println("Error: invalid entry for week=" + week_string + ", st=" + start + " and et=" + end);
			return false;
		} else
		{
			for (int i = 0; i < 7; i++)
			{
				// System.out.println("course: " + course[i]);
				// System.out.println("week: " + week[i]);
				course[i].and(week[i]);
				if (!course[i].isEmpty())
				{
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * Add a course.
	 * 
	 * @param week_string
	 *          A string that is accepted by the regular expression
	 *          '[Ss-]?[Mm-]?[Tt-]?[Ww-]?[Rr-]?[Ff-]?[Ss-]?', which cannot only
	 *          contain either an 'S' or an 's'.
	 * @param start
	 *          a start time, as an integer between 800 and 2000.
	 * @param end
	 *          an end time, as an integer between 800 and 2000.
	 * @return true, if successful.
	 */
	public boolean addCourse(String week_string, int start, int end)
	{
		if (testCourse(week_string, start, end))
		{
			BitSet[] course = toBitSetArray(week_string, start, end);
			for (int i = 0; i < 7; i++)
			{
				week[i].or(course[i]);
			}
			return true;
		}
		return false;
	}

	/**
	 * Drop a course.
	 * 
	 * @param week_string
	 *          A string that is accepted by the regular expression
	 *          '[Ss-]?[Mm-]?[Tt-]?[Ww-]?[Rr-]?[Ff-]?[Ss-]?', which cannot only
	 *          contain either an 'S' or an 's'.
	 * @param start
	 *          a start time, as an integer between 800 and 2000.
	 * @param end
	 *          an end time, as an integer between 800 and 2000.
	 * @return true, if successful.
	 */
	public boolean dropCourse(String week_string, int start, int end)
	{
		if (validateCourse(week_string, start, end))
		{
			BitSet[] course = toBitSetArray(week_string, start, end);
			for (int i = 0; i < 7; i++)
			{
				week[i].andNot(course[i]);
			}
			return true;
		}
		return false;
	}

}