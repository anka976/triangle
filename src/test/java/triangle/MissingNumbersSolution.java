package triangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Numeros, the Artist, had two lists  and , such that  was a permutation of . Numeros was very
 * proud of these lists. Unfortunately, while transporting them from one exhibition to another, some
 * numbers were left out of . Can you find the missing numbers?
 *
 * <h1>Notes</h1>
 *
 * If a number occurs multiple times in the lists, you must ensure that the frequency of that number
 * in both lists is the same. If that is not the case, then it is also a missing number. You have to
 * print all the missing numbers in ascending order. Print each missing number once, even if it is
 * missing multiple times. The difference between maximum and minimum number in  is less than or
 * equal to . Input Format
 *
 * <h2>There will be four lines of input:</h2>
 *
 * n - the size of the first list This is followed by  space-separated integers that make up the first
 * list. - the size of the second list This is followed by  space-separated integers that make up
 * the second list.
 *
 * Output Format
 *
 * Output the missing numbers in ascending order.
 *
 * Sample Input
 *
 * 10
 * 203 204 205 206 207 208 203 204 205 206
 * 13
 * 203 204 204 205 206 207 205 208 203 206 205 206 204
 * Sample Output
 *
 * 204 205 206
 *
 * Explanation
 *
 * is present in both arrays. Its frequency in  is , while its frequency in  is . Similarly,  and
 * occur twice in , but thrice in . So, these three numbers are our output. The rest of the numbers
 * have thesame frequency in both lists. Created by anna.kulikova on 04/03/2017.
 */
public class MissingNumbersSolution {
	public static void main(String[] args) {

		try (BufferedReader in = new BufferedReader(new FileReader
				("src/test/java/triangle/MissingNumberTest.txt"))
		) {
			Scanner sc = new Scanner(in);
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();

			int a = sc.nextInt();
			for (int i = 0; i < a; i++) {
				aList.add(sc.nextInt());
			}

			int b = sc.nextInt();
			for (int i = 0; i < b; i++) {
				bList.add(sc.nextInt());
			}
			aList.sort(Comparator.naturalOrder());
			bList.sort(Comparator.naturalOrder());
			System.out.println();
			Set<Integer> res = new HashSet<>();

			for (int i = 0; i < a; i++) {
				if (!Objects.equals(aList.get(i), bList.get(i))) {

					while (!Objects.equals(aList.get(i), bList.get(i))) {
						res.add(bList.get(i));
						bList.remove(i);
					}
				}
			}
			if (aList.size() < bList.size()) {
				for (int i = aList.size(); i < bList.size(); i++) {
					res.add(bList.get(i));
				}
			}
			System.out.println(res.stream().sorted(Comparator.naturalOrder()).map(Object::toString)
					.collect(Collectors.joining(" ")));
			System.out.println("2437 2438 2442 2444 2447 2451 2457 2458 2466 2473 2479 2483 2488 " +
					"2489 2510 2515 2517 2518");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
