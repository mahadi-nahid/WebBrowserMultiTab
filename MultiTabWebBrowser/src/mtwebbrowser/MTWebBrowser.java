
package mtwebbrowser;


import com.mahadihasan.gui.webbrowser.WebBrowserPane;
import com.mahadihasan.gui.webbrowser.WebToolBar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/**
 *
 * @author MAHADI HASAN NAHID
 */
public class MTWebBrowser extends JFrame {
    
    private final JTabbedPane tabbedPane = new JTabbedPane();
    
    
    
    public MTWebBrowser() {
        
        super("JTabbedPane Web Browser(NAHID)");
        
        createNewTab();
        
        getContentPane().add(tabbedPane);
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new NewTabAction());
        fileMenu.addSeparator();
        fileMenu.add(new ExitAction());
        fileMenu.setMnemonic('F');
        
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
    }    
    
    private void createNewTab() {
        
        JPanel panel = new JPanel(new BorderLayout());
        
        WebBrowserPane browserPane = new WebBrowserPane();
        WebToolBar toolBar = new WebToolBar(browserPane);
        
        
        panel.add(toolBar, BorderLayout.NORTH);
        panel.add(new JScrollPane(browserPane),
                BorderLayout.CENTER);
        
        tabbedPane.addTab("Browser "+tabbedPane.getTabCount(), 
                panel);
    }
    
    
    private class NewTabAction extends AbstractAction {
        
        
        public NewTabAction() {
            
            putValue(Action.NAME, "New Browser Tab");
            putValue(Action.SHORT_DESCRIPTION, 
                    "Create New Web Browser Tab");
            
            putValue(Action.MNEMONIC_KEY, new Integer('N'));
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            createNewTab();
        }
        
        
    }
    
    
    private class ExitAction  extends AbstractAction {
        
        public ExitAction() {
            
            putValue(Action.NAME, "Exit");
            putValue(Action.SHORT_DESCRIPTION, "Exit Application");
            
            putValue(Action.MNEMONIC_KEY, new Integer('X'));
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            System.exit(0);
        }
        
    }
    
    
    
    public static void main(String[] args) {
        
        MTWebBrowser browser = new MTWebBrowser();
        browser.setDefaultCloseOperation(EXIT_ON_CLOSE);
        browser.setSize(640, 480);
        browser.setVisible(true);
        
    }
}
