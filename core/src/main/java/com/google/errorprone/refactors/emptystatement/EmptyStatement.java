/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.refactors.emptystatement;

import static com.google.errorprone.BugPattern.Category.JDK;
import static com.google.errorprone.BugPattern.MaturityLevel.ON_BY_DEFAULT;
import static com.google.errorprone.BugPattern.SeverityLevel.WARNING;

import com.google.errorprone.BugPattern;
import com.google.errorprone.VisitorState;
import com.google.errorprone.fixes.SuggestedFix;
import com.google.errorprone.refactors.RefactoringMatcher;

import com.sun.source.tree.EmptyStatementTree;

/**
 * This checker finds and fixes empty statements, for example:
 * if (foo == 10);
 * ;
 * 
 * @author eaftan@google.com (Eddie Aftandilian)
 */
@BugPattern(
    name = "Empty statement",
    category = JDK,
    severity = WARNING,
    maturity = ON_BY_DEFAULT,
    summary = "Empty statement",
    explanation =
        "An empty statement has no effect on the program. Consider removing it.")
public class EmptyStatement extends RefactoringMatcher<EmptyStatementTree> {

  @Override
  public boolean matches(EmptyStatementTree emptyStatementTree, VisitorState state) {
    return true;
  }

  @Override
  public Refactor refactor(
      EmptyStatementTree emptyStatementTree, VisitorState state) {
    return new Refactor(
        emptyStatementTree,
        refactorMessage,
        new SuggestedFix().delete(emptyStatementTree));
  }

}