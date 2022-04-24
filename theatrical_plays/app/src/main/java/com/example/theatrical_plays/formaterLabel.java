package com.example.theatrical_plays;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class formaterLabel extends ValueFormatter implements IAxisValueFormatter {

        private ArrayList<String> mLabels = new ArrayList<String>();

        public formaterLabel(ArrayList<String> labels) {
            mLabels = labels;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mLabels.get((int) value);
        }
}
