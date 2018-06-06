package com.zeetcode.aafb.array;

/**
 * Some people will make friend requests. The list of their ages is given and
 * ages[i] is the age of the ith person.
 * 
 * Person A will NOT friend request person B (B != A) if any of the following
 * conditions are true:
 * 
 * age[B] <= 0.5 * age[A] + 7 age[B] > age[A] age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B.
 * 
 * Note that if A requests B, B does not necessarily request A. Also, people
 * will not friend request themselves.
 * 
 * How many total friend requests are made?
 */
public class FriendOfAppropiateAge {
	public int numFriendRequests(int[] ages) {
		int[] count = new int[121];
		for (int age : ages) {
			count[age]++;
		}

		int ans = 0;
		for (int ageA = 0; ageA <= 120; ageA++) {
			int countA = count[ageA];
			for (int ageB = 0; ageB <= 120; ageB++) {
				int countB = count[ageB];
				if (isRequest(ageA, ageB)) {
					ans += countA * countB;
					if (ageA == ageB) {
						// people will not friend request themselves, so subtract
						ans -= countA;
					}
				}
			}
		}
		return ans;
	}

	private boolean isRequest(int a, int b) {
		return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
	}

	public int numFriendRequestsBetter(int[] ages) {
		int res = 0;
		int[] numInAge = new int[121], sumInAge = new int[121];

		for (int i : ages) {
			numInAge[i]++;
		}

		for (int i = 1; i <= 120; ++i) {
			sumInAge[i] = numInAge[i] + sumInAge[i - 1];
		}

		for (int i = 15; i <= 120; ++i) {
			if (numInAge[i] == 0)
				continue;
			int count = sumInAge[i] - sumInAge[i / 2 + 7];

			// people will not friend request themselves, so - numInAge[i]
			res += count * numInAge[i] - numInAge[i];
		}

		return res;
	}
}
