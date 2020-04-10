package com.ccamacho.udemycoursejetpack.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.ccamacho.udemycoursejetpack.R;
import com.ccamacho.udemycoursejetpack.models.Todo;

public class TodoView extends ConstraintLayout {

    private CheckBox completeCheckbox;
    private TextView descriptionView;

    public TodoView(Context context) {
        super(context);
    }

    public TodoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TodoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Todo todo) {
        completeCheckbox = findViewById(R.id.complete_checkBox);
        descriptionView = findViewById(R.id.description_view);

        descriptionView.setText(todo.getDescription());
        completeCheckbox.setChecked(todo.isComplete());

        if (todo.isComplete()) {
            createStrikeThrough();
        }

        setUpCheckStateListener();
    }

    public void setUpCheckStateListener() {
        completeCheckbox.setOnCheckedChangeListener((button, isChecked) -> {
            removeStrikeThrough();
            if (isChecked) {
                createStrikeThrough();
            }
        });
    }

    private void createStrikeThrough() {
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void removeStrikeThrough() {
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
    }
}
