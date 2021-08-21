import java.util.*;

public class textToBinary
{
	public static void main(String[] args)
	{
		Map<Integer, String> map = new HashMap<>();
		List<String> arrList = new ArrayList<String>();
		Collections.addAll(arrList, " ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/",
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@", "A", "B", "C", "D",
			"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
			"Z", "[", "\\", "]", "^", "_", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}", "~");

		for(int i = 32; i <= 126; i++)
		{
			map.put(i, arrList.get(i - 32));
		}

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] letters = input.split("");
		List<String> binaryList = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < letters.length; i++)
		{
			if(Integer.toBinaryString(getKey(map, letters[i])).length() == 7)
			{
				letters[i] = "0" + Integer.toBinaryString(getKey(map, letters[i]));
				binaryList.add(letters[i]);
			}
			else
			{
				letters[i] = "00" + Integer.toBinaryString(getKey(map, letters[i]));
				binaryList.add(letters[i]);
			}
		}

		for(int i = 0; i < binaryList.size(); i++)
		{
			str.append(binaryList.get(i) + " ");
		}
		System.out.println(str);
	}

	public static <K, V> K getKey(Map<K, V> map, V value)
	{
	    for (Map.Entry<K, V> entry : map.entrySet())
	    {
	        if (value.equals(entry.getValue()))
	        {
	            return entry.getKey();
	        }
	    }
    return null;
	}
}