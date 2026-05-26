**Day 75 – #100DaysOfLeetCode 🚀**

Today I solved **LeetCode 3120 – Count the Number of Special Characters I**.

🔍 **Problem Overview:**
Given a string `word`, a character is considered **special** if it appears in **both lowercase and uppercase** in the string.

👉 The goal is to count how many such special characters exist.

Example:
Input: "aaAbcBC"
Output: 3 (a, b, c)

---

💡 **Approach – Using Sets for Efficient Lookup:**

🔹 Traverse the string and store:

* Lowercase characters in one set
* Uppercase characters in another set

🔹 Then:
✔️ For each lowercase character
✔️ Check if its uppercase version exists

👉 Count all such matches

---

⏱ **Complexity:**
Time Complexity: **O(n)**
Space Complexity: **O(1)**

---

📚 **Key Learning:**
This problem reinforced:

* Efficient use of **HashSet** for lookups
* Clean separation of conditions
* Writing simple yet optimal solutions

---

💭 **Reflection:**
Not every problem needs complex logic — sometimes clarity and simplicity lead to the best solutions.

Day 75 of my #100DaysOfLeetCode journey — building consistency and sharpening fundamentals 💪🔥

#Day75 #100DaysOfLeetCode #LeetCode3120 #Java #ProblemSolving #DataStructures #CodingJourney #Consistency
