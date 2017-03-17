/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmaxscale;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.awt.Color;
import java.io.InputStream;

/**
 *
 * @author obissick
 */
public class ui extends javax.swing.JPanel {

    /**
     * Creates new form ui
     */
    public ui() {
        initComponents();
        
    }
    
    private String hostString;
    private String user;
    private String passwordString;
    private String command = " ";
    private String mxUser = "";
    private String mxPassword = "mariadb";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        host = new javax.swing.JTextField();
        hostLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        runButton = new javax.swing.JButton();
        comLabel = new javax.swing.JLabel();
        comList = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        clearButton = new javax.swing.JButton();
        configButton = new javax.swing.JToggleButton();
        detailLabel = new javax.swing.JLabel();
        maxUser = new javax.swing.JTextField();
        maxPassword = new javax.swing.JTextField();

        host.setToolTipText("Enter credentials for server running MaxScale.");
        host.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        host.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hostFocusLost(evt);
            }
        });

        hostLabel.setText("Host:");

        userLabel.setText("Username:");

        userName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameFocusLost(evt);
            }
        });

        passwordLabel.setText("Password:");

        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });

        result.setEditable(false);
        result.setColumns(20);
        result.setRows(5);
        jScrollPane1.setViewportView(result);

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        comLabel.setText("Command:");

        comList.setEditable(true);
        comList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "list clients", "list dcbs", "list filters", "list listeners", "list modules", "list monitors", "list services", "list servers", "list sessions", "list threads", "show dcbs", "show dcb", "show dbusers", "show epoll", "show event", "show eventstats", "show feedbackreport", "show filter", "show filters", "show modules", "show monitor", "show monitors", "show server", "show servers", "show serversjson", "show services", "show service", "show session", "show sessions", "show tasks", "show threads", "show users" }));
        comList.setToolTipText("MaxScale command to run.(Enter other options if needed.)");

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        configButton.setText("Show Config");
        configButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configButtonActionPerformed(evt);
            }
        });

        detailLabel.setText("Host Details");

        maxUser.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        maxUser.setText("username");
        maxUser.setToolTipText("Enter MaxScale username.");
        maxUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                maxUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                maxUserFocusLost(evt);
            }
        });

        maxPassword.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        maxPassword.setText("password");
        maxPassword.setToolTipText("Enter MaxScale password.");
        maxPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                maxPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                maxPasswordFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comLabel)
                                        .addGap(4, 4, 4)
                                        .addComponent(comList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(maxUser))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(hostLabel)
                                        .addGap(2, 2, 2)
                                        .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(userLabel)
                                        .addGap(6, 6, 6)
                                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(passwordLabel)
                                        .addGap(3, 3, 3)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(maxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(runButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(clearButton)
                                        .addGap(12, 12, 12)
                                        .addComponent(configButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(detailLabel)))
                        .addGap(0, 110, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hostLabel)
                    .addComponent(userLabel)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runButton)
                    .addComponent(comLabel)
                    .addComponent(comList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton)
                    .addComponent(configButton)
                    .addComponent(maxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hostFocusLost
        
        IPAddressValidator isIP = new IPAddressValidator();
        if(isIP.validate(host.getText())){
            hostString = host.getText();
            host.setBackground(Color.green);
        }else{
            if(!host.getText().isEmpty()){
                host.setBackground(Color.red);
            }else{
                host.setBackground(Color.white);
            }
        }
    }//GEN-LAST:event_hostFocusLost

    private void userNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFocusLost
        
        user = userName.getText();
    }//GEN-LAST:event_userNameFocusLost

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        
        passwordString = password.getText();
    }//GEN-LAST:event_passwordFocusLost

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        
        int itemIndex = comList.getSelectedIndex();
        if(maxUser.getText().equals("username") && maxPassword.getText().equals("password") || maxUser.getText().isEmpty() && maxPassword.getText().isEmpty()){
            Thread thread = new Thread(
                () -> {
                    runCom(hostString,user,passwordString,"maxadmin -pmariadb " + comList.getEditor().getItem().toString());
            });
            thread.start();
        }else{
            Thread thread = new Thread(
                    () -> {
                        runCom(hostString,user,passwordString,"maxadmin -u " + mxUser + " -p" +mxPassword + comList.getEditor().getItem().toString());
            });
            thread.start();
        }
    }//GEN-LAST:event_runButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        
        result.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void configButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configButtonActionPerformed
        String cnfFile = "/etc/maxscale.cnf";
        Thread thread = new Thread(
                () -> {
                    runCom(hostString,user,passwordString,"cat "+cnfFile);
        });
        thread.start();
    }//GEN-LAST:event_configButtonActionPerformed

    private void maxUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUserFocusLost
        if(maxUser.getText().isEmpty()){
            maxUser.setText("username");
        }else{
            mxUser = maxUser.getText();
        }
    }//GEN-LAST:event_maxUserFocusLost

    private void maxUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUserFocusGained
         maxUser.setText("");
    }//GEN-LAST:event_maxUserFocusGained

    private void maxPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxPasswordFocusGained
        maxPassword.setText("");
    }//GEN-LAST:event_maxPasswordFocusGained

    private void maxPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxPasswordFocusLost
        if(maxPassword.getText().isEmpty()){
            maxPassword.setText("password");
        }else{
            mxPassword = maxPassword.getText();
        }
    }//GEN-LAST:event_maxPasswordFocusLost

    private void runCom(String host, String user, String password, String command) {
        try{
	    	
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	JSch jsch = new JSch();
	    	Session session=jsch.getSession(user, host, 22);
	    	session.setPassword(password);
	    	session.setConfig(config);
	    	session.connect();
	    	result.append("Running command..."+"\n");
	    
	    	Channel channel=session.openChannel("exec");
	        ((ChannelExec)channel).setCommand(command);
	        channel.setInputStream(null);
	        ((ChannelExec)channel).setErrStream(System.err);
	        
	        InputStream in=channel.getInputStream();
	        channel.connect();
	        byte[] tmp=new byte[1024];
	        while(true){
	          while(in.available()>0){
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            result.append(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            //result.append("exit-status: "+channel.getExitStatus() + "\n");
	            break;
	          }
	          try{
                      Thread.sleep(1000);
                  }catch(Exception ee){
                  
                  }
	        }
	        channel.disconnect();
	        session.disconnect();
	        //result.append("DONE");
	    }catch(Exception e){
	    	result.append(e.getMessage());
	    }

	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel comLabel;
    private javax.swing.JComboBox<String> comList;
    private javax.swing.JToggleButton configButton;
    private javax.swing.JLabel detailLabel;
    private javax.swing.JTextField host;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField maxPassword;
    private javax.swing.JTextField maxUser;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextArea result;
    private javax.swing.JButton runButton;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
