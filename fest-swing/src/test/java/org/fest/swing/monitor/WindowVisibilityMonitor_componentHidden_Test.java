/*
 * Created on Oct 10, 2007
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2007-2013 the original author or authors.
 */
package org.fest.swing.monitor;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Test;

/**
 * Tests for {@link WindowVisibilityMonitor#componentHidden(java.awt.event.ComponentEvent)}.
 *
 * @author Alex Ruiz
 */
public class WindowVisibilityMonitor_componentHidden_Test extends WindowVisibilityMonitor_TestCase {
  @Test
  public void should_mark_Window_as_hidden_when_Window_is_hidden() {
    monitor.componentHidden(componentEventWithWindowAsSource());
    verify(windows).markAsHidden(window);
  }

  @Test
  public void should_not_mark_Window_as_hidden_if_Component_hidden_is_not_Window() {
    monitor.componentHidden(componentEventWithTextFieldAsSource());
    verifyZeroInteractions(windows);
  }
}
