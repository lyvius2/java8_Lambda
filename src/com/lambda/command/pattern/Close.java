package com.lambda.command.pattern;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Close implements Action{
    private final Editor editor;

    public Close(Editor editor){
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }
}
