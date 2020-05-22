/*
 * Copyright 2014-2019 michael-simons.eu.
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
package ac.simons.biking2.statistics.highcharts;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author Michael J. Simons
 *
 * @since 2014-02-11
 */
class AxisTest {

    @Test
    void testBuilder() {
        Axis axis = new Axis.Builder<>(object -> object)
                .withCategories("a", "b")
                .withMin(0)
                .withMax(2109)
                .withTickInterval(100)
                .enableEndOnTick()
                .title()
                    .withText("test")
                    .build()
                .withPlotLine()
                    .at(23)
                    .build()
                .withPlotLine()
                    .at(42)
                    .build()
                .build();
        assertThat(axis.getCategories(), is(equalTo(Arrays.asList("a", "b"))));
        assertThat(axis.getMin(), is(equalTo(0)));
        assertThat(axis.getMax(), is(equalTo(2109)));
        assertThat(axis.getTickInterval(), is(equalTo(100)));
        assertThat(axis.isEndOnTick(), is(true));
        assertThat(axis.getTitle().getText(), is(equalTo("test")));
        assertThat(axis.getPlotLines().size(), is(equalTo(2)));
        assertThat(axis.getPlotLines().toArray(new PlotLine[2])[0].getValue(), is(equalTo(23)));
        assertThat(axis.getPlotLines().toArray(new PlotLine[2])[1].getValue(), is(equalTo(42)));

        axis = new Axis.Builder<>(object -> object)
                .enableEndOnTick()
                .disableEndOnTick()
        .build();
        assertThat(axis.isEndOnTick(), is(false));
        assertThat(axis.getPlotLines(), is(nullValue()));
    }

}
