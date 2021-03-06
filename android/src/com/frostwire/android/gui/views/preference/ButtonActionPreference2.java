/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011-2017, FrostWire(R). All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.frostwire.android.gui.views.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.frostwire.android.R;

/**
 * @author gubatron
 * @author aldenml
 */
public final class ButtonActionPreference2 extends Preference {

    private CharSequence buttonText;

    private Button button;

    private OnClickListener listener;

    public ButtonActionPreference2(Context context, AttributeSet attrs) {
        super(context, attrs);

        setLayoutResource(R.layout.view_preference_button_action_2);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ButtonActionPreference);
        buttonText = attributes.getString(R.styleable.ButtonActionPreference_button_text);
        attributes.recycle();
    }

    public void setOnActionListener(OnClickListener listener) {
        this.listener = listener;
        if (button != null) {
            button.setOnClickListener(listener);
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        button = (Button) holder.findViewById(R.id.view_preference_button_action_button);
        button.setText(buttonText);
        if (listener != null) {
            button.setOnClickListener(listener);
        }
    }
}
