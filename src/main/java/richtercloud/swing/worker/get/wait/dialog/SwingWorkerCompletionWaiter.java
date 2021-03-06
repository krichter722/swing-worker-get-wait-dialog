/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package richtercloud.swing.worker.get.wait.dialog;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.SwingWorker;

/**
 * A {@link PropertyChangeListener}  as suggested in {@link SwingWorker#get() }.
 * @author richter
 */
public class SwingWorkerCompletionWaiter implements PropertyChangeListener {
    private JDialog dialog;

    public SwingWorkerCompletionWaiter(JDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if ("state".equals(event.getPropertyName())
                && SwingWorker.StateValue.DONE == event.getNewValue()) {
            dialog.setVisible(false);
            dialog.dispose();
        }
    }
}