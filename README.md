
english version : https://github.com/Thereisnospon/CodeView/blob/master/READ_ENGLISH.md

# CodeView


CodeView 是一个能显示代码，并且能够进行代码高亮的一个控件。
这里是通过hightlight.js 渲染代码，可以自动识别主流的各种语言
比如*java,c++,c#,python,bash,ruby*。。。。等等等语言
并且有很多种主题风格，可以自由选择一种主题，然后将其显示
比如：

<table>
  <tr>
    <td>
    <img src="http://img.blog.csdn.net/20160621185326512" width="216"  height="382"/>
    </td>
    <td>
    <img src="http://img.blog.csdn.net/20160621185350184" width="216"  height="382"/>
    </td>
    <td>
    <img src="http://img.blog.csdn.net/20160621185403236" width="216"  height="382"/>
    </td>
  </tr>
   <tr>
    <td>
    <img src="http://img.blog.csdn.net/20160621185418189" width="216"  height="382"/>
    </td>
    <td>
    <img src="http://img.blog.csdn.net/20160621185434418" width="216"  height="382"/>
    </td>
    <td>
    
    </td>
  </tr>
</table>




既可以显示单个代码片段，也可以把html文件中所有指定的代码替换为高亮显示出来，而其他部分保留不变。
大概就是这个效果：

 <img src="http://img.blog.csdn.net/20160621185651975" width="216"  height="382"/>


## 获取方法(gradle)


```
compile 'thereisnospon.codeview:codeview:0.3.1'

```

然后就获取好了，如果有问题，那应该是被墙的锅。

具体使用方法，非常简单，首先在 layout文件中
```xml
 <thereisnospon.codeview.CodeView
        android:id="@+id/codeview"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
</thereisnospon.codeview.CodeView>
```
然后在代码中使用它,就像这样

```java
 public class MainActivity extends AppCompatActivity {
    CodeView codeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codeView=(CodeView)findViewById(R.id.codeview);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        //这里的CODE 为需要显示的代码，类型为String，使用的时候自己替换下。
        codeView.showCode(CODE);
    }
}
```
然后就可以了。一般来说，可以自动识别代码的语言。
以上是用来显示单个代码片段，也可以用来把一个html文件中的代码全部替换为高亮显示。
比如对于下面的html文件
```html
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
<h1>This is a code</h1>
<pre class="code">
#include<stdio.h>
int main()
{
	printf("hello world");
}
</pre>
<h1>This is another code</h1>
<pre class="code">
class Main
{
	private String name;
	Main(String name){
		this.name=name;
	}
	public static void main(String []args){
		Main main=new Main("hello");
		System.out.println("init");
	}
}
</pre>
</body>
</html>
```
如果要把其中的代码替换为高亮显示的话呢，可以这样,通过原来放代码的标签的类，来将代码高亮显示。

```java
 codeView.showCodeHtmlByClass(Constant.HTML,"code");
```
也可以用 css 的选择器，来选中需要高亮的代码区域.就像这样
```java
 codeView.showCodeHtmlByCssSelect(Constant.HTML,".code");
```

## 更换主题

默认的主题类型为 DEFAULT ,主题类型为一个枚举值,大概这样更换主题。
```java
 codeView.setTheme(CodeViewTheme.DRACULA)
```
可以通过调用方法 查看所有主题类型。
```java
 public static CodeViewTheme[]listThemes()；
```
再介绍几个其它的方法:
```java
	//设置编码类型，默认utf-8
	public CodeView setEncode(String encode);
	//填充背景颜色
	public CodeView fillColor()；
	//显示代码，自动识别语言
	public void showCode(String code)；
	//显示代码，指定语言（这个还没搞定，因为目前自动识别已经很方便了。。
	public void showCode(Code code)
```

也可以把这个项目clone到本地，app里有具体的使用demo，可以浏览下所有的主题，和一些具体用法。


如果觉得不错的话，可以点击这里点个赞什么的的

当然，这是第一次尝试写开源库，如果有哪些不好的地方，或者有什么bug，可以给我一点建议，每个批评都是一次学习的机会


邮箱：thereisnospon@qq.com

## Release Demo 

应大家要求，发布了 release 版本，大家可以到这里 https://github.com/Thereisnospon/CodeView/releases
查看demo的效果。



## 版本微调：

0.2.1版本中，把最小sdk版本修改为14，可供更低版本的android 使用。

## 0.3.0 更新

增加了两个方法,用来解决网页显示图片的时候大多数图片用相对地址，导致图片显示不出的bug
```java
   public void setBaseUrl(String baseUrl
   public void setHistoryUrl(String historyUrl)
```


代码高亮的渲染部分，是通过highlight.js 实现的。

Copyright (c) 2006, Ivan Sagalaev
All rights reserved.
Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of highlight.js nor the names of its contributors 
      may be used to endorse or promote products derived from this software 
      without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.


在操作html文件中使用了 Jsoup 库
