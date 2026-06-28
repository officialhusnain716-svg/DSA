	public class FindClosestNumberToZeroBrute {

    public static int findClosestNumber(int[] nums) {
        int closest = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(closest)) {
                closest = nums[i];
            } else if (Math.abs(nums[i]) == Math.abs(closest) && nums[i] > closest) {
                closest = nums[i];
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, 4, 8};
        System.out.println("Closest Number = " + findClosestNumber(nums));
    }
}



public class FindClosestNumberToZeroOptimal {

    public static int findClosestNumber(int[] nums) {
        int answer = nums[0];

        for (int num : nums) {
            if (Math.abs(num) < Math.abs(answer)
                    || (Math.abs(num) == Math.abs(answer) && num > answer)) {
                answer = num;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, 4, 8};
        System.out.println("Closest Number = " + findClosestNumber(nums));
    }
}



public class IsSubsequenceBrute {
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++)
            if (s.charAt(i) == t.charAt(j))
                i++;
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}







public class IsSubsequenceOptimal {
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}





import java.util.*;

public class SummaryRangesBrute {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1)
                i++;
            if (start == nums[i])
                res.add(start + "");
            else
                res.add(start + "->" + nums[i]);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}

import java.util.*;

public class SummaryRangesOptimal {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            int j = i;
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                j++;
            ans.add(i == j ? nums[i] + "" : nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}



public class LongestCommonPrefixBrute {
    public static String longestCommonPrefix(String[] strs) {
        String p = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (!strs[i].startsWith(p))
                p = p.substring(0, p.length() - 1);
        return p;
    }

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }
}

import java.util.Arrays;

public class LongestCommonPrefixOptimal {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String a = strs[0], b = strs[strs.length - 1];
        int i = 0;
        while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i))
            i++;
        return a.substring(0, i);
    }

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }
}


public class BestTimeToBuySellStockBrute {

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++)
            for (int j = i + 1; j < prices.length; j++)
                max = Math.max(max, prices[j] - prices[i]);
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}




public class BestTimeToBuySellStockOptimal {

    public static int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;
        for (int p : prices) {
            if (p < min) min = p;
            profit = Math.max(profit, p - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

import java.util.Arrays;

public class ContainsDuplicateBrute {

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i - 1]) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
}


public class TwoSumBrute {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ans = twoSum(nums, 9);
        System.out.println(ans[0] + " " + ans[1]);
    }
}



import java.util.HashMap;

public class TwoSumOptimal {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x))
                return new int[]{map.get(x), i};
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ans = twoSum(nums, 9);
        System.out.println(ans[0] + " " + ans[1]);
    }
}


public class MaximumNumberOfBalloonsBrute {

    public static int maxNumberOfBalloons(String text) {
        int[] c = new int[26];

        for (char ch : text.toCharArray())
            c[ch - 'a']++;

        return Math.min(
                Math.min(c['b' - 'a'], c['a' - 'a']),
                Math.min(Math.min(c['l' - 'a'] / 2, c['o' - 'a'] / 2), c['n' - 'a'])
        );
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
}

public class MaximumNumberOfBalloonsOptimal {

    public static int maxNumberOfBalloons(String text) {
        int[] f = new int[26];

        for (char ch : text.toCharArray())
            f[ch - 'a']++;

        return Math.min(
                Math.min(f[1], f[0]),
                Math.min(Math.min(f[11] / 2, f[14] / 2), f[13])
        );
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
}



import java.util.Arrays;

public class ValidAnagramBrute {

    public static boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}



public class ValidAnagramOptimal {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] f = new int[26];

        for (int i = 0; i < s.length(); i++) {
            f[s.charAt(i) - 'a']++;
            f[t.charAt(i) - 'a']--;
        }

        for (int x : f)
            if (x != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}



import java.util.*;

public class GroupAnagramsBrute {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] vis = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (vis[i]) continue;

            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            vis[i] = true;

            char[] a = strs[i].toCharArray();
            Arrays.sort(a);

            for (int j = i + 1; j < strs.length; j++) {
                char[] b = strs[j].toCharArray();
                Arrays.sort(b);

                if (Arrays.equals(a, b)) {
                    list.add(strs[j]);
                    vis[j] = true;
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));
    }
}


public class ReverseStringBrute {

    public static void reverseString(char[] s) {
        char[] temp = new char[s.length];

        for (int i = 0; i < s.length; i++)
            temp[i] = s[s.length - 1 - i];

        for (int i = 0; i < s.length; i++)
            s[i] = temp[i];
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }
}

public class ReverseStringOptimal {

    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }
}


public class ValidPalindromeBrute {

    public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}


public class ValidPalindromeOptimal {

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {

            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}




public class ContainerWithMostWaterBrute {

    public static int maxArea(int[] h) {
        int max = 0;

        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                int area = Math.min(h[i], h[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }
}


public class ContainerWithMostWaterOptimal {

    public static int maxArea(int[] h) {
        int left = 0, right = h.length - 1;
        int max = 0;

        while (left < right) {
            int area = Math.min(h[left], h[right]) * (right - left);
            max = Math.max(max, area);

            if (h[left] < h[right])
                left++;
            else
                right--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }
}


import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class InvertBinaryTreeBrute {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        invertTree(root);
        System.out.println(root.left.val);
    }
}



class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class InvertBinaryTreeOptimal {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        invertTree(root);
        System.out.println(root.left.val);
    }
}

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) {
        val = v;
    }
}

public class MaximumDepthOfBinaryTreeBrute {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                TreeNode cur = q.poll();

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
    }
}

public class MaximumDepthOfBinaryTreeOptimal {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
    }
}

public class MaximumDepthOfBinaryTreeOptimal {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
}

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
    }
}

public class KthSmallestElementInBSTBrute {

    static List<Integer> list = new ArrayList<>();

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    static int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(kthSmallest(root, 2));
    }
}


import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
    }
}

public class KthSmallestElementInBSTOptimal {

    static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (true) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();

            if (--k == 0)
                return root.val;

            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(kthSmallest(root, 2));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class DiameterOfBinaryTreeBrute {

    static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int diameter(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        int ld = diameter(root.left);
        int rd = diameter(root.right);

        return Math.max(left + right, Math.max(ld, rd));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(diameter(root));
    }
}


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class DiameterOfBinaryTreeOptimal {

    static int ans = 0;

    static int depth(TreeNode root) {
        if (root == null) return 0;

        int l = depth(root.left);
        int r = depth(root.right);

        ans = Math.max(ans, l + r);

        return 1 + Math.max(l, r);
    }

    static int diameter(TreeNode root) {
        depth(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(diameter(root));
    }
}




import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class ValidateBinarySearchTreeBrute {

    static List<Integer> list = new ArrayList<>();

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    static boolean isValidBST(TreeNode root) {
        inorder(root);

        for (int i = 1; i < list.size(); i++)
            if (list.get(i) <= list.get(i - 1))
                return false;

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST(root));
    }
}



import java.util.ArrayList;

public class ImplementTrieBrute {

    ArrayList<String> list = new ArrayList<>();

    public void insert(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        return list.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String s : list)
            if (s.startsWith(prefix))
                return true;
        return false;
    }

    public static void main(String[] args) {
        ImplementTrieBrute trie = new ImplementTrieBrute();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}



class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean end;
}

public class ImplementTrieOptimal {

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.child[i] == null)
                cur.child[i] = new TrieNode();
            cur = cur.child[i];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.child[i] == null)
                return false;
            cur = cur.child[i];
        }
        return cur.end;
    }

    public boolean startsWith(String pre) {
        TrieNode cur = root;
        for (char c : pre.toCharArray()) {
            int i = c - 'a';
            if (cur.child[i] == null)
                return false;
            cur = cur.child[i];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrieOptimal trie = new ImplementTrieOptimal();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("app"));
    }
}



import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class MinimumAbsoluteDifferenceInBSTBrute {

    static List<Integer> list = new ArrayList<>();

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    static int getMinimumDifference(TreeNode root) {
        inorder(root);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                ans = Math.min(ans, Math.abs(list.get(i) - list.get(j)));

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(getMinimumDifference(root));
    }
}


class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class MinimumAbsoluteDifferenceInBSTOptimal {

    static Integer prev = null;
    static int ans = Integer.MAX_VALUE;

    static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null)
            ans = Math.min(ans, root.val - prev);

        prev = root.val;

        inorder(root.right);
    }

    static int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(getMinimumDifference(root));
    }
}


import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val=x; }
}

public class RemoveDuplicatesFromSortedListBrute {

    static ListNode deleteDuplicates(ListNode head){
        ArrayList<Integer> list=new ArrayList<>();
        while(head!=null){
            if(list.isEmpty()||list.get(list.size()-1)!=head.val)
                list.add(head.val);
            head=head.next;
        }
        ListNode dummy=new ListNode(0),cur=dummy;
        for(int x:list){
            cur.next=new ListNode(x);
            cur=cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode a=new ListNode(1);
        a.next=new ListNode(1);
        a.next.next=new ListNode(2);
        System.out.println(deleteDuplicates(a).val);
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}

public class RemoveDuplicatesFromSortedListOptimal{

    static ListNode deleteDuplicates(ListNode head){
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            if(cur.val==cur.next.val)
                cur.next=cur.next.next;
            else
                cur=cur.next;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode a=new ListNode(1);
        a.next=new ListNode(1);
        a.next.next=new ListNode(2);
        System.out.println(deleteDuplicates(a).val);
    }
}

import java.util.HashSet;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}

public class LinkedListCycleBrute{

    static boolean hasCycle(ListNode head){
        HashSet<ListNode> set=new HashSet<>();
        while(head!=null){
            if(set.contains(head)) return true;
            set.add(head);
            head=head.next;
        }
        return false;
    }

    public static void main(String[] args){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        a.next=b;
        b.next=a;
        System.out.println(hasCycle(a));
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}

public class LinkedListCycleOptimal{

    static boolean hasCycle(ListNode head){
        ListNode slow=head,fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }

    public static void main(String[] args){
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        a.next=b;
        b.next=a;
        System.out.println(hasCycle(a));
    }
}

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}

public class MergeTwoSortedListsBrute{

    static ListNode merge(ListNode l1,ListNode l2){
        ArrayList<Integer> list=new ArrayList<>();

        while(l1!=null){list.add(l1.val);l1=l1.next;}
        while(l2!=null){list.add(l2.val);l2=l2.next;}

        Collections.sort(list);

        ListNode dummy=new ListNode(0),cur=dummy;
        for(int x:list){
            cur.next=new ListNode(x);
            cur=cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode a=new ListNode(1);
        a.next=new ListNode(3);
        ListNode b=new ListNode(2);
        b.next=new ListNode(4);

        System.out.println(merge(a,b).val);
    }
}

import java.util.*;

public class LastStoneWeightBrute {

    public static int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int s : stones) list.add(s);

        while (list.size() > 1) {
            Collections.sort(list);
            int y = list.remove(list.size() - 1);
            int x = list.remove(list.size() - 1);
            if (y != x) list.add(y - x);
        }

        return list.isEmpty() ? 0 : list.get(0);
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}

import java.util.*;

public class KthLargestElementBrute {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }
}


import java.util.*;

public class KthLargestElementOptimal {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }
}

import java.util.*;

public class TopKFrequentElementsBrute {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());

        int[] ans = new int[k];
        for (int i=0;i<k;i++)
            ans[i]=list.get(i).getKey();

        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
}

import java.util.*;

public class TopKFrequentElementsOptimal {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for (int key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k)
                pq.poll();
        }

        int[] ans = new int[k];
        for (int i=k-1;i>=0;i--)
            ans[i]=pq.poll();

        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
}









