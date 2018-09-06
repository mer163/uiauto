package com.zbwx.autotest.ui.browser;

import com.zbwx.autotest.ui.utils.WebMatchMode;

public class TableColText
{
    private int colIndex;
    
    private String text;

    private WebMatchMode mode;
    
    private TableColText(int colIndex, String text, WebMatchMode mode)
    {
        this.colIndex = colIndex;
        this.text = text;
        this.mode = mode;
    }

    public static TableColText colText(int colIndex, String text, WebMatchMode mode)
    {
        return new TableColText(colIndex, text, mode);
    }

    public static TableColText colText(int colIndex, String text)
    {
        return new TableColText(colIndex, text, WebMatchMode.PartialMatch);
    }

    public int getColIndex()
    {
        return colIndex;
    }

    public void setColIndex(int colIndex)
    {
        this.colIndex = colIndex;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public WebMatchMode getMode()
    {
        return mode;
    }

    public void setMode(WebMatchMode mode)
    {
        this.mode = mode;
    }
}