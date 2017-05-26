/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmaxscale;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author obissick
 */
public class TransferFile {
    
    private int    SFTPPORT = 22;
    private Session     session     = null;
    private Channel     channel     = null;
    private ChannelSftp channelSftp = null;
    String SFTPWORKINGDIR = "/etc/";
    
    public void upload(String file, String host,String user, String password){
        
        try{
            JSch jsch = new JSch();
            session = jsch.getSession(user,host,SFTPPORT);
            session.setPassword(password);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp)channel;
            channelSftp.cd(SFTPWORKINGDIR);
            File f = new File(file);
            channelSftp.put(new FileInputStream(f), f.getName());
            channel.disconnect();
            session.disconnect();    
        }catch(JSchException | SftpException | FileNotFoundException ex){
            
        }
 
    }
    
    public void download(String file, String host,String user, String password){
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, SFTPPORT);
            session.setPassword(password);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR);
            byte[] buffer = new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(channelSftp.get("maxscale.cnf"));
            File newFile = new File("maxscale.cnf");
            OutputStream os = new FileOutputStream(newFile);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int readCount;
            while ((readCount = bis.read(buffer)) > 0) {
                System.out.println("Writing: ");
                bos.write(buffer, 0, readCount);
            }
            bis.close();
            bos.close();
            channel.disconnect();
            session.disconnect(); 
        } catch (JSchException | SftpException | IOException ex) {
            System.out.println(ex.toString());
        }
    }
}

