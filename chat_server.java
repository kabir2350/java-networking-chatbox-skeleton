
import java.io.*;
import java.net.*;
public class chat_server extends javax.swing.JFrame {
    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    public chat_server() {
        initComponents();
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_text = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setAlwaysOnTop(true);
        setForeground(java.awt.Color.black);
        msg_area.setEditable(false);
        msg_area.setBackground(new java.awt.Color(0, 0, 0));
        msg_area.setColumns(20);
        msg_area.setForeground(new java.awt.Color(255, 255, 255));
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);
        msg_text.setBackground(new java.awt.Color(0, 255, 204));
        msg_text.setFont(new java.awt.Font("Rod", 0, 14)); // NOI18N
        msg_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        msg_text.setText("dssdf");
        msg_text.setToolTipText("fdsff");
        msg_text.setBorder(javax.swing.BorderFactory.createTitledBorder("Write Text"));
        msg_text.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        msg_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_textActionPerformed(evt);
            }
        });

        msg_send.setBackground(new java.awt.Color(153, 204, 255));
        msg_send.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        msg_send.setText("SEND");
        msg_send.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.black));
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        jLabel1.setText("server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msg_text, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg_text)
                    .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        msg_text.getAccessibleContext().setAccessibleName("");
        msg_text.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>                        

    private void msg_textActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        try{
            String msgout = "";
            msgout = msg_text.getText().trim();
            dout.writeUTF(msgout); // sending server msg to the client...
            msg_text.setText(" ");
        }catch(Exception e){
            // handle the exceptions here...
        
        }
        
    }                                        

    
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_server().setVisible(true);
            }
        });
        
        String msgin="";
        try{
            
            ss = new ServerSocket(1201); //server starts at 1201 port number
            s = ss.accept(); //now server will accept the connection
            
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            while(!msgin.equals("exit")){
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim()+"\n Client: \t"+msgin); // Displaying the msg. . .from client
                
            }
            
        }catch(Exception e){
        
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private javax.swing.JTextField msg_text;
    // End of variables declaration                   
}
