/*
 * $Id: TestMultiboxTag2.java 54929 2004-10-16 16:38:42Z germuska $ 
 *
 * Copyright 1999-2004 The Apache Software Foundation.
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
package org.apache.struts.taglib.html;

import java.util.Locale;

import javax.servlet.jsp.PageContext;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.cactus.JspTestCase;
import org.apache.struts.Globals;
import org.apache.struts.taglib.SimpleBeanForTesting;

/**
 * Suite of unit tests for the
 * <code>org.apache.struts.taglib.html.MultiboxTag</code> class.
 *  NOTE - These tests were separated into 4 files each because of the
 *         size of the jsp. (not playing well with Tomcat 3.3
 *
 *  These tests are numbered as such:
 *
 *  1 thru 4 test a single checkbox
 *  TestMultiboxTag1 - These test validate true (a value was in the array) on our form.
 *  TestMultiboxTag2 - Same as 1, but using BodyContent instead of value attribute
 *
 *  TestMultiboxTag3 - These test validate true (a value was in the array) on our form.
 *  TestMultiboxTag4 - Same as 3, but using BodyContent instead of value attribute
 *
 *  5 thru 8 test multiple checkboxes
 *  TestMultiboxTag5 - These test validate true (a value was in the array) on our form.
 *  TestMultiboxTag6 - Same as 5, but using BodyContent instead of value attribute
 *
 *  TestMultiboxTag7 - These test validate true (a value was in the array) on our form.
 *  TestMultiboxTag8 - Same as 7, but using BodyContent instead of value attribute
 *
 *
 */
public class TestMultiboxTag2 extends JspTestCase {

    /**
     * Defines the testcase name for JUnit.
     *
     * @param theName the testcase's name.
     */
    public TestMultiboxTag2(String theName) {
        super(theName);
    }

    /**
     * Start the tests.
     *
     * @param theArgs the arguments. Not used
     */
    public static void main(String[] theArgs) {
        junit.awtui.TestRunner.main(new String[] {TestMultiboxTag2.class.getName()});
    }

    /**
     * @return a test suite (<code>TestSuite</code>) that includes all methods
     *         starting with "test"
     */
    public static Test suite() {
        // All methods starting with "test" will be executed in the test suite.
        return new TestSuite(TestMultiboxTag2.class);
    }

    private void runMyTest(String whichTest, String locale) throws Exception {
        pageContext.setAttribute(Globals.LOCALE_KEY,
                        new Locale(locale, locale),
                        PageContext.SESSION_SCOPE);

                String[] s = new String[7];
                for(int i = 1; i < 7; i++){
                        s[i] = "value" + i;
                }
                SimpleBeanForTesting sbft = new SimpleBeanForTesting(s);

        pageContext.setAttribute(Constants.BEAN_KEY, sbft, PageContext.REQUEST_SCOPE);
        request.setAttribute("runTest", whichTest);
        pageContext.forward("/test/org/apache/struts/taglib/html/TestMultiboxTag2.jsp");
    }

    /*
     * Testing MultiboxTag.
     */
    public void testMultiboxBodyPropertyTrue() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrue", "");
        }
    public void testMultiboxBodyPropertyTrueAccesskey() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueAccesskey", "");
        }
    public void testMultiboxBodyPropertyTrueAlt() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueAlt", "");
        }
    public void testMultiboxBodyPropertyTrueAltKey1() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueAltKey1", "");
        }
    public void testMultiboxBodyPropertyTrueAltKey2() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueAltKey2", "");
        }
    public void testMultiboxBodyPropertyTrueAltKey_fr1() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueAltKey1_fr", "fr");
        }
    public void testMultiboxBodyPropertyTrueAltKey_fr2() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueAltKey2_fr", "fr");
        }
    public void testMultiboxBodyPropertyTrueDisabled_True() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueDisabled_True", "");
        }
    public void testMultiboxBodyPropertyTrueDisabled_False1() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueDisabled_False1", "");
        }
    public void testMultiboxBodyPropertyTrueDisabled_False2() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueDisabled_False2", "");
        }
    public void testMultiboxBodyPropertyTrueOnblur() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnblur", "");
        }

    public void testMultiboxBodyPropertyTrueOnchange() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnchange", "");
        }

    public void testMultiboxBodyPropertyTrueOnclick() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnclick", "");
        }

    public void testMultiboxBodyPropertyTrueOndblclick() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOndblclick", "");
        }

    public void testMultiboxBodyPropertyTrueOnfocus() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnfocus", "");
        }

    public void testMultiboxBodyPropertyTrueOnkeydown() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnkeydown", "");
        }

    public void testMultiboxBodyPropertyTrueOnkeypress() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnkeypress", "");
        }

    public void testMultiboxBodyPropertyTrueOnkeyup() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnkeyup", "");
        }

    public void testMultiboxBodyPropertyTrueOnmousedown() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnmousedown", "");
        }

    public void testMultiboxBodyPropertyTrueOnmousemove() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnmousemove", "");
        }

    public void testMultiboxBodyPropertyTrueOnmouseout() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnmouseout", "");
        }

    public void testMultiboxBodyPropertyTrueOnmouseover() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnmouseover", "");
        }

    public void testMultiboxBodyPropertyTrueOnmouseup() throws Exception {
        runMyTest("testMultiboxBodyPropertyTrueOnmouseup", "");
        }

}
