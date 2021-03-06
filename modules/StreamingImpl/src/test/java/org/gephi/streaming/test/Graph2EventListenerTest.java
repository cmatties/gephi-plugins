/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>, Andre Panisson <panisson@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */

package org.gephi.streaming.test;

import static org.junit.Assert.*;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphFactory;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.GraphObserver;
import org.gephi.graph.api.Node;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.gephi.streaming.api.Graph2EventListener;
import org.junit.Test;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author panisson
 */
public class Graph2EventListenerTest {

    @Test
    public void test() {
        ProjectController projectController = Lookup.getDefault().lookup(ProjectController.class);
        projectController.newProject();
        projectController.newWorkspace(projectController.getCurrentProject());

        GraphController graphController = Lookup.getDefault().lookup(GraphController.class);
        GraphModel graphModel = graphController.getGraphModel();
        Graph graph = graphModel.getGraph();
        GraphFactory factory = graphModel.factory();

        MockGraphEventHandler handler = new MockGraphEventHandler();
        final Graph2EventListener graph2EventListener = new Graph2EventListener(graph, handler);
        
        GraphObserver graphObserver = graphModel.createGraphObserver(graph, true);

        Node node1 = factory.newNode();
        graph.addNode(node1);
        Node node2 = factory.newNode();
        graph.addNode(node2);

        Edge edge = factory.newEdge(node1, node2);
        graph.addEdge(edge);
        
        assertTrue(graphObserver.hasGraphChanged());
        graph2EventListener.graphChanged(graphObserver.getDiff());

        graph.removeEdge(edge);
        graph.removeNode(node1);
        graph.removeNode(node2);

        assertTrue(graphObserver.hasGraphChanged());
        graph2EventListener.graphChanged(graphObserver.getDiff());
        assertEquals(6, handler.getEventCount());
    }

}
