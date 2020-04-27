package org.flowable.engine.impl.util;

import org.flowable.common.engine.api.variable.ScopedVariableContainer;
import org.flowable.common.engine.api.variable.ScopedVariableContainerImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ievgenii Bespal
 */
public class ScopedVariableContainerHelper {
    private final ScopedVariableContainer variables;
    private final ScopedVariableContainer transientVariables;

    public ScopedVariableContainerHelper() {
        this.variables = new ScopedVariableContainerImpl(false);
        this.transientVariables = new ScopedVariableContainerImpl(true);
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables.setVariables(new HashMap<>(variables), false);
    }

    public void setVariablesLocal(Map<String, Object> variablesLocal) {
        this.variables.setVariables(new HashMap<>(variablesLocal), true);
    }

    public void setTransientVariables(Map<String, Object> transientVariables) {
        this.transientVariables.setVariables(new HashMap<>(transientVariables), false);
    }

    public void setTransientVariablesLocal(Map<String, Object> transientVariablesLocal) {
        this.transientVariables.setVariables(new HashMap<>(transientVariablesLocal), true);
    }

    public void setVariable(String variableName, Object variableValue) {
        this.variables.setVariable(variableName, variableValue, false);
    }

    public void setVariableLocal(String variableName, Object variableValue) {
        this.variables.setVariable(variableName, variableValue, true);
    }

    public void setTransientVariable(String variableName, Object variableValue) {
        this.transientVariables.setVariable(variableName, variableValue, false);
    }

    public void setTransientVariableLocal(String variableName, Object variableValue) {
        this.transientVariables.setVariable(variableName, variableValue, true);
    }

    public Map<String, Object> getVariables() {
        return this.variables.getVariables(false);
    }

    public Map<String, Object> getVariablesLocal() {
        return this.variables.getVariables(true);
    }

    public Map<String, Object> getTransientVariables() {
        return this.transientVariables.getVariables(false);
    }

    public Map<String, Object> getTransientVariablesLocal() {
        return this.transientVariables.getVariables(true);
    }

    public Map<String, Object> getAllVariables() {
        Map<String, Object> variables = null;

        if (hasAnyVariables()) {
            variables = new HashMap<>();
            if (hasVariables()) {
                variables.putAll(getVariables());
            }
            if (hasVariablesLocal()) {
                variables.putAll(getVariablesLocal());
            }
        }
        return variables;
    }

    public Map<String, Object> getAllTransientVariables() {
        Map<String, Object> transientVariables = null;

        if (hasAnyTransientVariables()) {
            transientVariables = new HashMap<>();
            if (hasTransientVariables()) {
                transientVariables.putAll(getTransientVariables());
            }
            if (hasTransientVariablesLocal()) {
                transientVariables.putAll(getTransientVariablesLocal());
            }
        }
        return transientVariables;
    }


    public Object getVariable(String variableName) {
        return this.variables.getVariable(variableName, false);
    }

    public Object getVariableLocal(String variableName) {
        return this.variables.getVariable(variableName, true);

    }

    public Object getTransientVariable(String variableName) {
        return this.transientVariables.getVariable(variableName, false);

    }

    public Object getTransientVariableLocal(String variableName) {
        return this.transientVariables.getVariable(variableName, true);
    }

    public boolean hasVariable(String variableName) {
        return this.variables.hasVariable(variableName, false);
    }

    public boolean hasVariableLocal(String variableName) {
        return this.variables.hasVariable(variableName, true);

    }

    public boolean hasTransientVariable(String variableName) {
        return this.transientVariables.hasVariable(variableName, false);

    }

    public boolean hasTransientVariableLocal(String variableName) {
        return this.transientVariables.hasVariable(variableName, true);
    }

    public boolean hasVariables() {
        return this.variables.hasVariables(false);
    }

    public boolean hasVariablesLocal() {
        return this.variables.hasVariables(true);
    }

    public boolean hasTransientVariables() {
        return this.transientVariables.hasVariables(false);
    }

    public boolean hasTransientVariablesLocal() {
        return this.transientVariables.hasVariables(true);
    }

    public boolean hasAnyTransientVariables() {
        return hasTransientVariables() || hasTransientVariablesLocal();
    }

    public boolean hasAnyVariables() {
        return hasVariables() || hasVariablesLocal();
    }
}
