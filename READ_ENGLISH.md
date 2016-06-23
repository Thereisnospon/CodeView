# CodeView

(my engilsh is not good ,if you have any question,you can ask me by e-mail : thereisnospon@qq.com)
CodeView is a android widget can show code and hightlight it .
it's hightlight code by hightlight.js , can auto recognize language 
such as java,c++,c#,python,bash,ruby*...and more language 

it has many themes,and you can choose one:
example:

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



it  can not only show code snippet，but also  hightlight all code in html ，

etc：

 <img src="http://img.blog.csdn.net/20160621185651975" width="216"  height="382"/>


## get(gradle)


add this code to build.gradle:
```
repositories {
    maven {
        url  "http://dl.bintray.com/thereisnospon/maven"
    }
}
```
then add this two lines to dependencies:

```
compile(group: 'thereisnospon.codeview', name: 'codeview', version: '0.3.0', ext: 'aar', classifier: '')
compile 'org.jsoup:jsoup:1.9.2'
```

if the 0.3.0 version have wrong,you can try 0.2.0

then is ok

## use

in the layout:
```xml
 <thereisnospon.codeview.CodeView
        android:id="@+id/codeview"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
</thereisnospon.codeview.CodeView>
```
in java code：

```java
 public class MainActivity extends AppCompatActivity {
    CodeView codeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codeView=(CodeView)findViewById(R.id.codeview);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO).fillColor();
        //CODE is your code which  you want to show,type is String
        codeView.showCode(CODE);
    }
}
```

then is ok,it can recognize your code language  automatically。

if you want hightlight many code snippet in a html:

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

this code snippet both have a same class "code"

you can hightlight theme by two ways:


```java
 codeView.showCodeHtmlByClass(Constant.HTML,"code");
```

you can also using css selector ,such as:

```java
 codeView.showCodeHtmlByCssSelect(Constant.HTML,".code");
```

## change theme

default theme is  DEFAULT 。CodeViewTheme is a enum type
```java
 codeView.setTheme(CodeViewTheme.DRACULA)
```
you can using this method to list all themes
```java
 public static CodeViewTheme[]listThemes()；
```
som other methods:
```java
	//set encoding ,utf-8 is default
	public CodeView setEncode(String encode);
	//fill background color
	public CodeView fillColor()；
	//show code ,recognize language automatically。
	public void showCode(String code)；
	//show code and  specifying language,but it is undone.
	public void showCode(Code code)
```

you can clone this project to local,app have som useage demo,you can browse all theme and concreate useage


if you think is interesting ,can give a star

ofcourse ,it is my first open source library,it must have many trouble,and bug,you can give me some addvice,
and then,i can learn more.




mail ：thereisnospon@qq.com

## Release Demo 



there is a release version: https://github.com/Thereisnospon/CodeView/releases

## version update 1 ：

0.2.1 change min sdk to 14

## 0.3.0 update

add two methods ,fix show image in html (because many image url is  relative address)
```java
   public void setBaseUrl(String baseUrl
   public void setHistoryUrl(String historyUrl)
```


using highlight.js to hightlight

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

and using Jsoup to parse thml

