/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.codegen;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.CompileCompilerDependenciesTest;
import org.jetbrains.jet.analyzer.AnalyzeExhaust;
import org.jetbrains.jet.lang.psi.JetFile;
import org.jetbrains.jet.lang.resolve.java.AnalyzerFacadeForJVM;
import org.jetbrains.jet.lang.resolve.java.CompilerSpecialMode;

import java.util.Collections;

/**
 * @author Stepan Koltsov
 */
public class GenerationUtils {

    public static ClassFileFactory compileFileGetClassFileFactoryForTest(@NotNull JetFile psiFile, @NotNull CompilerSpecialMode compilerSpecialMode) {
        return compileFileGetGenerationStateForTest(psiFile, compilerSpecialMode).getFactory();
    }

    public static GenerationState compileFileGetGenerationStateForTest(JetFile psiFile, @NotNull CompilerSpecialMode compilerSpecialMode) {
        final AnalyzeExhaust analyzeExhaust = AnalyzerFacadeForJVM.analyzeOneFileWithJavaIntegrationAndCheckForErrors(
                psiFile, CompileCompilerDependenciesTest.compilerDependenciesForTests(compilerSpecialMode, true));
        analyzeExhaust.throwIfError();
        GenerationState state = new GenerationState(psiFile.getProject(), ClassBuilderFactories.binaries(false), analyzeExhaust, Collections.singletonList(psiFile));
        state.compileCorrectFiles(CompilationErrorHandler.THROW_EXCEPTION);
        return state;
    }

}
