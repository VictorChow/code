package me.victor.code;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/simplify-path/
 */
class T71_SimplifyPath {

    public static void main(String[] args) {
        var t = new T71_SimplifyPath();
        System.out.println(t.simplifyPath("/home/./ab./.../.."));
        System.out.println(t.simplifyPath("/../"));
        System.out.println(t.simplifyPath("/home//foo/"));
        System.out.println(t.simplifyPath("/a/./b/../../c/"));
        System.out.println(t.simplifyPath("/a/...b/../...c/d//.."));
    }

    public String simplifyPath(String path) {
        var stack = new Stack<String>();
        for (String s : path.split("/")) {
            if (s.isEmpty() || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }

    public String simplifyPath2(String path) {
        var stack = new Stack<String>();
        var dotCount = 0;
        var separator = false;
        var folder = new StringBuilder();
        for (char c : path.toCharArray()) {
            if (c == '/') {
                if (separator) continue;
                separator = true;
                handleBlock(stack, dotCount, folder);
                dotCount = 0;
            } else if (c == '.') {
                separator = false;
                if (!folder.isEmpty()) folder.append(c);
                else dotCount++;
            } else {
                if (dotCount != 0) folder.append(".".repeat(dotCount));
                dotCount = 0;
                separator = false;
                folder.append(c);
            }
        }
        handleBlock(stack, dotCount, folder);
        return "/" + String.join("/", stack);
    }

    private void handleBlock(Stack<String> stack, int dotCount, StringBuilder folder) {
        if (folder.isEmpty()) {
            if (dotCount == 2) {
                if (!stack.isEmpty()) stack.pop();
            } else if (dotCount > 2) stack.add(".".repeat(dotCount));
        } else {
            stack.push(folder.toString());
            folder.delete(0, folder.length());
        }
    }
}
