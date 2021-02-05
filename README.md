# LinedEditText

An edit text allows creating many styles of edit text with lines.

<img src="/attachments/overview.png" width="1000" />

- [Gradle](#gradle)
- [Usage](#usage)
- [Attributes](#attributes)
- [License](#license)

## Gradle

Step 1. Add this in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://www.jitpack.io' }
        }
    }

Step 2. Add dependency

    dependencies {
        ...
        implementation 'com.github.homanad:LinedEditText:1.0.0'
    }

## Usage

This is done simply by add this View into your layout:

    <com.homanad.android.widget.LinedEditText
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

## Attributes

For ease of use, you can also set all values in the corresponding code
as follows:

| Attribute      	| XML 					| Description 																|	Type 			| Default value	|
| ----------- 		| ----------- 			|----------- 																| -----------		|	-----------	|
| dashWidth 		| let_dashWidth			| The length of each dash when using the line with dashed lines    			|	Dimension		|	2dp			|
| dashGap    		| let_dashGap			| The distance of each dash when you want to use the line with solid lines	|	Dimension		|	2dp			|
| lineWidth  		| let_lineWidth			| The width of the line, in the x-direction									|	Dimension		|	1dp			|
| lineColor   		| let_lineColor			| Line color  																|	Color resource	|	Black		|
| isShowLines   	| let_showLines			| Option for showing or hiding lines 										|	Boolean			|	true		|
| lineStyle  		| let_lineStyle			| Determines the style of the line: stroke, dashes, or dots       			|	Enum			|	stroke		|
| dotSpace   		| let_dotSpace			| For dot style, this attribute is used to define the spacing between dots  |	Dimension		|	3dp			|
| lineSpacingExtra  | let_lineSpacingExtra	| The distance of the line from the footer        							|	Dimension		|	1dp			|

Here, notice the values written with ".dp" extension

Because these attributes are dimension values, so for an Int or Float
value become a dp value, I've provided two extension functions to
convert the Int or Float type to dp, you just need to call it as an
extension function.

## License

```
Copyright 2021 Man Ho

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```