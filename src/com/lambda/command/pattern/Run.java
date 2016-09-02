package com.lambda.command.pattern;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Run {
    private static Editor editor = new Editor() {
        @Override
        public void save() {
            System.out.println("Save...");
        }

        @Override
        public void open() {
            System.out.println("Open...");
        }

        @Override
        public void close() {
            System.out.println("Close...");
        }
    };

    public static void main(String[] args) {
        // 전통적인 방식
        Macro macro = new Macro();

        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));
        macro.run();

        // 람다 식
        Macro macro2 = new Macro();
        macro2.record(() -> editor.open());
        macro2.record(() -> editor.save());
        macro2.record(() -> editor.close());
        macro2.run();

        // 메서드 참조
        Macro macro3 = new Macro();
        macro3.record(editor::open);
        macro3.record(editor::save);
        macro3.record(editor::close);
        macro3.run();
    }
}
