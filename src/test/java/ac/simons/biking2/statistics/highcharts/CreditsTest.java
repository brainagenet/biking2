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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author Michael J. Simons
 *
 * @since 2014-02-11
 */
class CreditsTest {

    @Test
    void testBuilder() {
        Credits credits = new Credits.Builder<>(object -> object).build();
        assertThat(credits.isEnabled(), is(true));

        credits = new Credits.Builder<>(object -> object).disable().build();
        assertThat(credits.isEnabled(), is(false));

        credits = new Credits.Builder<>(object -> object).enable().build();
        assertThat(credits.isEnabled(), is(true));
    }
}
