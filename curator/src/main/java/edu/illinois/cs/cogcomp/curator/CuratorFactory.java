/**
 * This software is released under the University of Illinois/Research and Academic Use License. See
 * the LICENSE file in the root folder for details. Copyright (c) 2016
 *
 * Developed by: The Cognitive Computation Group University of Illinois at Urbana-Champaign
 * http://cogcomp.cs.illinois.edu/
 */
package edu.illinois.cs.cogcomp.curator;

import edu.illinois.cs.cogcomp.annotation.AnnotatorService;
import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation;
import edu.illinois.cs.cogcomp.core.utilities.configuration.ResourceManager;

/**
 * A simple factory for an {@link CuratorAnnotatorService} object.
 *
 * @author Christos Christodouloupoulos
 */
public class CuratorFactory {

    public static AnnotatorService buildCuratorClient() throws Exception {
        return new CuratorAnnotatorService();
    }

    public static AnnotatorService buildCuratorClient(ResourceManager rm) throws Exception {
        return new CuratorAnnotatorService(rm);
    }
    public static void main(String[] args) throws Exception{
        try {
            AnnotatorService annotator = CuratorFactory.buildCuratorClient();
            TextAnnotation ta = annotator.createBasicTextAnnotation("0","0", "Some text that I want to process.");
            annotator.addView(ta, ViewNames.POS);
            annotator.addView(ta, ViewNames.NER_CONLL);
            System.out.println(ta.getAvailableViews());
        }
        catch (Exception e){

        }
    }
}
