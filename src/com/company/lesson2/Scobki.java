package com.company.lesson2;

import java.util.Scanner;
import java.util.Stack;

public class Scobki {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Scanner inp = new Scanner(System.in);
        String cmd = inp.nextLine();
        char a;
        int i,k;
        boolean flag=true;
        for (i=0; i<cmd.length(); i++)
        {
            a=cmd.charAt(i);
            switch (a)
            {
                case '(':
                    st.push(1);
                    break;
                case '[':
                    st.push(2);
                    break;
                case '{':
                    st.push(3);
                    break;
                case ')':
                    if (st.empty())
                    {
                        flag=false;
                        break;
                    }
                    k=st.peek();
                    st.pop();
                    if (k!=1) flag=false;
                    break;
                case ']':
                    if (st.empty())
                    {
                        flag=false;
                        break;
                    }
                    k=st.peek();
                    st.pop();
                    if (k!=2) flag=false;
                    break;
                case '}':
                    if (st.empty())
                    {
                        flag=false;
                        break;
                    }
                    k=st.peek();
                    st.pop();
                    if (k!=3) flag=false;
                    break;
                default:
            }
            if (! flag) break;
        }

        if (flag && st.empty())
            System.out.println("True");
        else
            System.out.println("False");
    }
}
