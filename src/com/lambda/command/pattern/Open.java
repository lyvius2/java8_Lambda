package com.lambda.command.pattern;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Open implements Action {
    private final Editor editor;

    public Open(Editor editor){
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
