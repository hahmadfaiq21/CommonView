# RecyclerView of Common View Classes
<p align="center">
  <img src="https://github.com/user-attachments/assets/4f4147c8-bba7-469c-936f-dd6ba203331b">
</p>

The **View** class is a fundamental building block of the Android user interface (UI). It serves as the superclass for various GUI components, including **TextView**, **ImageView**, and **Button**. Here are some key points about **View**:

1. **Definition**: A **View** represents a rectangular area on the screen that displays content, such as text, images, or buttons. Although the rectangle is invisible, each View occupies a specific space. The size of this rectangle can be set manually or using predefined values: <br>
a. **match_parent**: Occupies the entire available space on the device display. <br>
b. **wrap_content**: Occupies only the necessary space for its content to display. <br>
2. **Attributes**: When defining a **View** in XML, you’ll use attributes to specify how it should appear on the screen. Two essential attributes are: <br>
a. **android:layout_height**: Determines the height of the **View**. <br>
b. **android:layout_width**: Sets the width of the **View**. <br>
3. **Widgets**: Any visual and interactive element visible on the screen is called a **Widget**. Views are also known as widgets in Android.
4. **XML Syntax**: To create a **View**, you’ll define it in XML files. The format for each **View** is as follows:

```XML
<ViewName
    Attribute1="Value1"
    Attribute2="Value2"
    ...
    AttributeN="ValueN" />
```
Replace **ViewName** with the specific **View** type (e.g., **TextView**, **ImageView**). Attributes control the appearance and behavior of the **View**. <br>
Example:
```XML
<TextView
        android:id="@+id/text_view_id"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="@string/hello" />
```
More: https://developer.android.com/reference/android/view/View

This project is a simple implementation of **RecyclerView** to introduce **View** classes that commonly used in **Android Development**.

## User Interface (UI)
![Image](https://github.com/user-attachments/assets/813a79f6-af23-4df3-ad42-e05a459e1e83)
