/*******************************************************************************
 *        File: Global.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: Feb 22, 2014
 *     Project: tracker
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;

import play.i18n.Messages;
import play.mvc.Content;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render(Messages.get("application.name"));
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains(Messages.get("application.name"));
    }


}
