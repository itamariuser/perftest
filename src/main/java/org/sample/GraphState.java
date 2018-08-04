package org.sample;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class GraphState
{
    public static Graph graphChars = new CliqueGraph();
}