package thereisnospon.mcode;

/**
 * Created by yzr on 16/6/21.
 */
public class Constant {

    public static final String CODE="#include<iostream>  \n" +
            "#include<queue>  \n" +
            "#include<string>  \n" +
            "#include<cstdio>  \n" +
            "#include<cstring>  \n" +
            "#include<vector>  \n" +
            "#define MAX 2005  \n" +
            "using namespace std;  \n" +
            "int in[MAX];  \n" +
            "vector<int>G[MAX];  \n" +
            "int TopSort(int n)  \n" +
            "{  \n" +
            "    queue<int>p;  \n" +
            "    int i, t, Count = 0;  \n" +
            "    for (i = 1; i <= n; i++)  \n" +
            "        if (in[i] == 0)  \n" +
            "            p.push(i);  \n" +
            "    while (!p.empty())  \n" +
            "    {  \n" +
            "        t = p.front(); p.pop();  \n" +
            "        Count++;  \n" +
            "        for (i = 0; i < G[t].size(); i++)  \n" +
            "        {  \n" +
            "            in[G[t][i]]--;  \n" +
            "            if (in[G[t][i]] == 0)  \n" +
            "                p.push(G[t][i]);  \n" +
            "        }  \n" +
            "    }  \n" +
            "    if (Count <n)  \n" +
            "        return 1;  \n" +
            "    else return 0;  \n" +
            "  \n" +
            "}  \n" +
            "int main()  \n" +
            "{  \n" +
            "    int n, t, i, j, cc = 0;  \n" +
            "    cin.sync_with_stdio(false);  \n" +
            "    string s;  \n" +
            "    cin >> t;  \n" +
            "    while (t--)  \n" +
            "    {      \n" +
            "        cc++;  \n" +
            "        cin >> n;  \n" +
            "        memset(in, 0, sizeof(in));  \n" +
            "        for (int i = 0; i <= n; i++) G[i].clear();  \n" +
            "        for (i = 1; i <= n; i++)  \n" +
            "        {  \n" +
            "            cin >> s;  \n" +
            "            for (j = 0; j < s.size(); j++)  \n" +
            "            {  \n" +
            "                if (s[j] == '1')  \n" +
            "                {  \n" +
            "                    G[i].push_back(j + 1);  \n" +
            "                    in[j+1]++;  \n" +
            "  \n" +
            "                }  \n" +
            "            }  \n" +
            "        }  \n" +
            "        if (TopSort(n))  \n" +
            "            printf(\"Case #%d: Yes\\n\", cc);  \n" +
            "        else printf(\"Case #%d: No\\n\", cc);  \n" +
            "    }  \n" +
            "    return 0;  \n" +
            "}  ";

    public static final String HTML="<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title></title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>This is a code</h1>\n" +
            "<pre class=\"code\">\n" +
            "#include<stdio.h>\n" +
            "int main()\n" +
            "{\n" +
            "\tprintf(\"hello world\");\n" +
            "}\n" +
            "</pre>\n" +
            "<h1>This is another code</h1>\n" +
            "<pre class=\"code\">\n" +
            "class Main\n" +
            "{\n" +
            "\tprivate String name;\n" +
            "\tMain(String name){\n" +
            "\t\tthis.name=name;\n" +
            "\t}\n" +
            "\tpublic static void main(String []args){\n" +
            "\t\tMain main=new Main(\"hello\");\n" +
            "\t\tSystem.out.println(\"init\");\n" +
            "\t}\n" +
            "}\n" +
            "</pre>\n" +
            "</body>\n" +
            "</html>";

}
