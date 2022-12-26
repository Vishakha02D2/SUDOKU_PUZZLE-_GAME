
import static java.awt.Color.*;
import java.util.HashMap;
import java.util.Stack;
//import static java.awt.Color.blue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


public class SUDOKU_FRAME2 extends javax.swing.JFrame {

      private String number;
   
      private boolean globalVar = false;
      
      private Stack<HashMap<JButton,String>>st=new Stack<HashMap<JButton,String>>(); //creating stack with HashMap
      
      private String solvedBoard [][] = {                              //use Solved 2DMatrix solved sudoboard
          {"2","9","8","5","1","6","7","3","4"},
          {"4","1","3","2","7","8","5","6","9"},
          {"7","5","6","3","4","9","1","2","8"},
          {"8","2","1","4","3","5","6","9","7"},
          {"5","3","4","6","9","7","2","8","1"},
          {"9","6","7","1","8","2","3","4","5"},
          {"1","4","2","8","5","3","9","7","6"},
          {"3","7","5","9","6","4","8","1","2"},
          {"6","8","9","7","2","1","4","5","3"},
      };
      
    public SUDOKU_FRAME2() {
        
        initComponents();
         
    }
  
    private void Undo(){
        
        if(st.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please enter a value first before using the undo functionality ","Sudoku Game1",JOptionPane.INFORMATION_MESSAGE);
        }else{
            
            HashMap<JButton,String> deleted = st.pop();//deleted(r5c5,4)
            HashMap.Entry<JButton,String>entry = deleted.entrySet().stream().findFirst().get();
            JButton deletedBtn = entry.getKey();//r5c5
            boolean flag = false;
            Stack<HashMap<JButton,String>> tempSt=new Stack<HashMap<JButton,String>>(); 
      
             
           while(!st.isEmpty()){
                 
            HashMap<JButton,String> temp = st.pop();//temp(r5c5,2)
            tempSt.push(temp);
            
            HashMap.Entry<JButton,String> entry1 = deleted.entrySet().stream().findFirst().get();
            JButton comparedBtn = entry.getKey(); //r5c4
             String value = entry1.getValue();    //2
             
             if(deletedBtn == comparedBtn){
                 flag = true;
                 comparedBtn.setText(value);
                 break;
             }
           }
           
           if(flag == false){
               deletedBtn.setText("");
           }
           while(!tempSt.isEmpty()){
               
               HashMap<JButton,String> temp = tempSt.pop();
               st.push(temp);
           }
         }
    }
    public void chooseNumber(JButton btn){
        
        SelectionButton1.setBackground(black);
        SelectionButton2.setBackground(black);
        SelectionButton3.setBackground(black);
        SelectionButton4.setBackground(black);
        SelectionButton5.setBackground(black);
        SelectionButton6.setBackground(black);
        SelectionButton7.setBackground(black);
        SelectionButton8.setBackground(black);
        SelectionButton9.setBackground(black);
        
         btn.setBackground(blue);
        
        
        
}
    private void seeSolution(){
        
        JButton predefinedBtns[] = {r2c1,r3c1,r3c3,r1c4,r2c5,r2c6,r3c5,r1c7,r1c8,r1c9,r2c7,r2c9,r3c8,r5c2,
                                    r5c3,r6c2,r4c5,r4c6,r6c4,r6c5,r4c8,r5c7,r5c8,r7c2,r8c1,r9c1,r9c2,r9c3,r7c5,r8c4,r8c5,r9c6,r7c7,r7c9,r8c9};
       
        JButton btns [][] ={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9},
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9},
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9},
            {r4c1,r4c2,r4c2,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9},
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9},
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9},
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9},
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9},
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9},
        };
            
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                
                boolean flag = true;
                
                for(int k =0;k<predefinedBtns.length;k++){
                    
                    if(predefinedBtns[k]== btns[i][j]){
                        flag = false;
                        break;
                    }
                    
                }
                if(flag == true){
                    
                    if(globalVar == false){
                        
                    btns[i][j].setText(solvedBoard[i][j]);
                    btns[i][j].setBackground(black);
                    btns[i][j].setForeground(white);
                    
                }else{
                        
                       btns[i][j].setText("");
                       btns[i][j].setBackground(white);
                       btns[i][j].setForeground(black);
                    }
            }
        }
    }
        
        if(globalVar == false){
            
            globalVar = true;
           SolutionButton.setText("HIDE SOLUTION");
           
        }else{
            
            globalVar = false;
            SolutionButton.setText( "SOLUTION");
        }
    }
    
    private void CheckMoves(){
        
        JButton btns [][]={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9},
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9},
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9},
            {r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9},
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9},
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9},
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9},
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9},
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9},
        };
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                if(btns[i][j].getText()!=solvedBoard[i][j] && btns[i][j].getText()!=""){
                    
                    btns[i][j].setBackground(red);
                }
            }
        }
            
    }
    
    public void resetGame(){
        
        JButton predefinedBtns[] = {r2c1,r3c1,r3c3,r1c4,r2c5,r2c6,r3c5,r1c7,r1c8,r1c9,r2c7,r2c9,r3c8,r5c2,
                                    r5c3,r6c2,r4c5,r4c6,r6c4,r6c5,r4c8,r5c7,r5c8,r7c2,r8c1,r9c1,r9c2,r9c3,r7c5,r8c4,r8c5,r9c6,r7c7,r7c9,r8c9};
       
        JButton btns [][] ={
            {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9},
            {r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9},
            {r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9},
            {r4c1,r4c2,r4c2,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9},
            {r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9},
            {r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,r6c9},
            {r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,r7c9},
            {r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8,r8c9},
            {r9c1,r9c2,r9c3,r9c4,r9c5,r9c6,r9c7,r9c8,r9c9},
        };
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                
                boolean flag = true;
                
                for(int k =0;k<predefinedBtns.length;k++){
                    
                    if(predefinedBtns[k]== btns[i][j]){
                        flag = false;
                       
                    }
                    
                }
                if(flag == true){
                    
                   
                    btns[i][j].setText("");
                    btns[i][j].setBackground(white);
                    btns[i][j].setForeground(black);
                    
                    }
                }
            }
        st.clear();
    }

    
            
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        r4c3 = new javax.swing.JButton();
        r4c1 = new javax.swing.JButton();
        r4c2 = new javax.swing.JButton();
        r5c1 = new javax.swing.JButton();
        r5c2 = new javax.swing.JButton();
        r5c3 = new javax.swing.JButton();
        r6c1 = new javax.swing.JButton();
        r6c2 = new javax.swing.JButton();
        r6c3 = new javax.swing.JButton();
        SelectionButton2 = new javax.swing.JButton();
        SelectionButton1 = new javax.swing.JButton();
        SelectionButton4 = new javax.swing.JButton();
        SelectionButton3 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        r4c6 = new javax.swing.JButton();
        r4c4 = new javax.swing.JButton();
        r4c5 = new javax.swing.JButton();
        r5c4 = new javax.swing.JButton();
        r5c5 = new javax.swing.JButton();
        r5c6 = new javax.swing.JButton();
        r6c4 = new javax.swing.JButton();
        r6c5 = new javax.swing.JButton();
        r6c6 = new javax.swing.JButton();
        SelectionButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        r1c3 = new javax.swing.JButton();
        r1c1 = new javax.swing.JButton();
        r1c2 = new javax.swing.JButton();
        r2c1 = new javax.swing.JButton();
        r2c2 = new javax.swing.JButton();
        r2c3 = new javax.swing.JButton();
        r3c1 = new javax.swing.JButton();
        r3c2 = new javax.swing.JButton();
        r3c3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        r1c6 = new javax.swing.JButton();
        r1c4 = new javax.swing.JButton();
        r1c5 = new javax.swing.JButton();
        r2c4 = new javax.swing.JButton();
        r2c5 = new javax.swing.JButton();
        r2c6 = new javax.swing.JButton();
        r3c4 = new javax.swing.JButton();
        r3c5 = new javax.swing.JButton();
        r3c6 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        r7c9 = new javax.swing.JButton();
        r7c7 = new javax.swing.JButton();
        r7c8 = new javax.swing.JButton();
        r8c7 = new javax.swing.JButton();
        r8c8 = new javax.swing.JButton();
        r8c9 = new javax.swing.JButton();
        r9c7 = new javax.swing.JButton();
        r9c8 = new javax.swing.JButton();
        r9c9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        r1c9 = new javax.swing.JButton();
        r1c7 = new javax.swing.JButton();
        r1c8 = new javax.swing.JButton();
        r2c7 = new javax.swing.JButton();
        r2c8 = new javax.swing.JButton();
        r2c9 = new javax.swing.JButton();
        r3c7 = new javax.swing.JButton();
        r3c8 = new javax.swing.JButton();
        r3c9 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        r7c3 = new javax.swing.JButton();
        r7c1 = new javax.swing.JButton();
        r7c2 = new javax.swing.JButton();
        r8c1 = new javax.swing.JButton();
        r8c2 = new javax.swing.JButton();
        r8c3 = new javax.swing.JButton();
        r9c1 = new javax.swing.JButton();
        r9c2 = new javax.swing.JButton();
        r9c3 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        r4c9 = new javax.swing.JButton();
        r4c7 = new javax.swing.JButton();
        r4c8 = new javax.swing.JButton();
        r5c7 = new javax.swing.JButton();
        r5c8 = new javax.swing.JButton();
        r5c9 = new javax.swing.JButton();
        r6c7 = new javax.swing.JButton();
        r6c8 = new javax.swing.JButton();
        r6c9 = new javax.swing.JButton();
        SelectionButton5 = new javax.swing.JButton();
        SelectionButton7 = new javax.swing.JButton();
        SelectionButton8 = new javax.swing.JButton();
        UndoButton = new javax.swing.JButton();
        jButton136 = new javax.swing.JButton();
        CheckMovesButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        SolutionButton = new javax.swing.JButton();
        SelectionButton9 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        r7c6 = new javax.swing.JButton();
        r7c4 = new javax.swing.JButton();
        r7c5 = new javax.swing.JButton();
        r8c4 = new javax.swing.JButton();
        r8c5 = new javax.swing.JButton();
        r8c6 = new javax.swing.JButton();
        r9c4 = new javax.swing.JButton();
        r9c5 = new javax.swing.JButton();
        r9c6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setPreferredSize(new java.awt.Dimension(126, 126));

        r4c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c3ActionPerformed(evt);
            }
        });

        r4c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c1ActionPerformed(evt);
            }
        });

        r4c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c2ActionPerformed(evt);
            }
        });

        r5c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c1ActionPerformed(evt);
            }
        });

        r5c2.setBackground(new java.awt.Color(204, 153, 255));
        r5c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c2.setText("3");
        r5c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c2ActionPerformed(evt);
            }
        });

        r5c3.setBackground(new java.awt.Color(204, 153, 255));
        r5c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c3.setText("4");
        r5c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c3ActionPerformed(evt);
            }
        });

        r6c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c1ActionPerformed(evt);
            }
        });

        r6c2.setBackground(new java.awt.Color(204, 153, 255));
        r6c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c2.setText("6");
        r6c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c2ActionPerformed(evt);
            }
        });

        r6c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(r4c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(r5c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(r6c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r4c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r5c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r6c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SelectionButton2.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton2.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton2.setText("2");
        SelectionButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton2ActionPerformed(evt);
            }
        });

        SelectionButton1.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton1.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton1.setText("1");
        SelectionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton1ActionPerformed(evt);
            }
        });

        SelectionButton4.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton4.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton4.setText("4");
        SelectionButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton4ActionPerformed(evt);
            }
        });

        SelectionButton3.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton3.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton3.setText("3");
        SelectionButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton3ActionPerformed(evt);
            }
        });

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setPreferredSize(new java.awt.Dimension(126, 126));

        r4c6.setBackground(new java.awt.Color(204, 153, 255));
        r4c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c6.setText("5");
        r4c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c6ActionPerformed(evt);
            }
        });

        r4c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c4ActionPerformed(evt);
            }
        });

        r4c5.setBackground(new java.awt.Color(204, 153, 255));
        r4c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c5.setText("3");
        r4c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c5ActionPerformed(evt);
            }
        });

        r5c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c4ActionPerformed(evt);
            }
        });

        r5c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c5ActionPerformed(evt);
            }
        });

        r5c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c6ActionPerformed(evt);
            }
        });

        r6c4.setBackground(new java.awt.Color(204, 153, 255));
        r6c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c4.setText("1");
        r6c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c4ActionPerformed(evt);
            }
        });

        r6c5.setBackground(new java.awt.Color(204, 153, 255));
        r6c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c5.setText("8");
        r6c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c5ActionPerformed(evt);
            }
        });

        r6c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(r4c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(r5c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(r6c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r4c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r5c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r6c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SelectionButton6.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton6.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton6.setText("6");
        SelectionButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton6ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(126, 126));

        r1c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c3ActionPerformed(evt);
            }
        });

        r1c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c1ActionPerformed(evt);
            }
        });

        r1c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c2ActionPerformed(evt);
            }
        });

        r2c1.setBackground(new java.awt.Color(204, 153, 255));
        r2c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c1.setText("4");
        r2c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c1ActionPerformed(evt);
            }
        });

        r2c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c2ActionPerformed(evt);
            }
        });

        r2c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c3ActionPerformed(evt);
            }
        });

        r3c1.setBackground(new java.awt.Color(204, 153, 255));
        r3c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c1.setText("7");
        r3c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c1ActionPerformed(evt);
            }
        });

        r3c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c2ActionPerformed(evt);
            }
        });

        r3c3.setBackground(new java.awt.Color(204, 153, 255));
        r3c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c3.setText("6");
        r3c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(r1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(r2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(r3c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r1c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r2c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r3c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUDOKU PUZZLE GAME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(126, 126));

        r1c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c6ActionPerformed(evt);
            }
        });

        r1c4.setBackground(new java.awt.Color(204, 153, 255));
        r1c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c4.setText("5");
        r1c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c4ActionPerformed(evt);
            }
        });

        r1c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c5ActionPerformed(evt);
            }
        });

        r2c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c4ActionPerformed(evt);
            }
        });

        r2c5.setBackground(new java.awt.Color(204, 153, 255));
        r2c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c5.setText("7");
        r2c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c5ActionPerformed(evt);
            }
        });

        r2c6.setBackground(new java.awt.Color(204, 153, 255));
        r2c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c6.setText("8");
        r2c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c6ActionPerformed(evt);
            }
        });

        r3c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c4ActionPerformed(evt);
            }
        });

        r3c5.setBackground(new java.awt.Color(204, 153, 255));
        r3c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c5.setText("4");
        r3c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c5ActionPerformed(evt);
            }
        });

        r3c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(r1c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(r2c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(r3c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r1c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r2c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r3c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.setPreferredSize(new java.awt.Dimension(126, 126));

        r7c9.setBackground(new java.awt.Color(204, 153, 255));
        r7c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c9.setText("6");
        r7c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c9ActionPerformed(evt);
            }
        });

        r7c7.setBackground(new java.awt.Color(204, 153, 255));
        r7c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c7.setText("9");
        r7c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c7ActionPerformed(evt);
            }
        });

        r7c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c8ActionPerformed(evt);
            }
        });

        r8c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c7ActionPerformed(evt);
            }
        });

        r8c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c8ActionPerformed(evt);
            }
        });

        r8c9.setBackground(new java.awt.Color(204, 153, 255));
        r8c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c9.setText("2");
        r8c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c9ActionPerformed(evt);
            }
        });

        r9c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c7ActionPerformed(evt);
            }
        });

        r9c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c8ActionPerformed(evt);
            }
        });

        r9c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(r7c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(r8c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(r9c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r7c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r8c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r9c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(126, 126));

        r1c9.setBackground(new java.awt.Color(204, 153, 255));
        r1c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c9.setText("4");
        r1c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c9ActionPerformed(evt);
            }
        });

        r1c7.setBackground(new java.awt.Color(204, 153, 255));
        r1c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c7.setText("7");
        r1c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c7ActionPerformed(evt);
            }
        });

        r1c8.setBackground(new java.awt.Color(204, 153, 255));
        r1c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r1c8.setText("3");
        r1c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1c8ActionPerformed(evt);
            }
        });

        r2c7.setBackground(new java.awt.Color(204, 153, 255));
        r2c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c7.setText("5");
        r2c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c7ActionPerformed(evt);
            }
        });

        r2c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c8ActionPerformed(evt);
            }
        });

        r2c9.setBackground(new java.awt.Color(204, 153, 255));
        r2c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r2c9.setText("9");
        r2c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2c9ActionPerformed(evt);
            }
        });

        r3c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c7ActionPerformed(evt);
            }
        });

        r3c8.setBackground(new java.awt.Color(204, 153, 255));
        r3c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c8.setText("2");
        r3c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c8ActionPerformed(evt);
            }
        });

        r3c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r3c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(r1c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r1c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r1c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r2c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r2c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(r3c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r3c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r1c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r2c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r2c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r3c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r3c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.setPreferredSize(new java.awt.Dimension(126, 126));

        r7c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c3ActionPerformed(evt);
            }
        });

        r7c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c1ActionPerformed(evt);
            }
        });

        r7c2.setBackground(new java.awt.Color(204, 153, 255));
        r7c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c2.setText("4");
        r7c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c2ActionPerformed(evt);
            }
        });

        r8c1.setBackground(new java.awt.Color(204, 153, 255));
        r8c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c1.setText("3");
        r8c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c1ActionPerformed(evt);
            }
        });

        r8c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c2ActionPerformed(evt);
            }
        });

        r8c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c3ActionPerformed(evt);
            }
        });

        r9c1.setBackground(new java.awt.Color(204, 153, 255));
        r9c1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c1.setText("6");
        r9c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c1ActionPerformed(evt);
            }
        });

        r9c2.setBackground(new java.awt.Color(204, 153, 255));
        r9c2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c2.setText("8");
        r9c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c2ActionPerformed(evt);
            }
        });

        r9c3.setBackground(new java.awt.Color(204, 153, 255));
        r9c3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c3.setText("9");
        r9c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(r7c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(r8c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(r9c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r7c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r8c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r9c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setPreferredSize(new java.awt.Dimension(126, 126));

        r4c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c9ActionPerformed(evt);
            }
        });

        r4c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c7ActionPerformed(evt);
            }
        });

        r4c8.setBackground(new java.awt.Color(204, 153, 255));
        r4c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r4c8.setText("9");
        r4c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4c8ActionPerformed(evt);
            }
        });

        r5c7.setBackground(new java.awt.Color(204, 153, 255));
        r5c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c7.setText("2");
        r5c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c7ActionPerformed(evt);
            }
        });

        r5c8.setBackground(new java.awt.Color(204, 153, 255));
        r5c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c8.setText("8");
        r5c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c8ActionPerformed(evt);
            }
        });

        r5c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r5c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5c9ActionPerformed(evt);
            }
        });

        r6c7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c7ActionPerformed(evt);
            }
        });

        r6c8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c8ActionPerformed(evt);
            }
        });

        r6c9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r6c9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6c9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(r4c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r4c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r4c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(r5c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(r6c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r6c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r4c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r4c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r5c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r5c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r6c9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r6c7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SelectionButton5.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton5.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton5.setText("5");
        SelectionButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton5ActionPerformed(evt);
            }
        });

        SelectionButton7.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton7.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton7.setText("7");
        SelectionButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton7ActionPerformed(evt);
            }
        });

        SelectionButton8.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton8.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton8.setText("8");
        SelectionButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton8ActionPerformed(evt);
            }
        });

        UndoButton.setBackground(new java.awt.Color(255, 255, 0));
        UndoButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        UndoButton.setText("UNDO");
        UndoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoButtonActionPerformed(evt);
            }
        });

        jButton136.setBackground(new java.awt.Color(255, 153, 51));
        jButton136.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton136.setText("EXIT");
        jButton136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton136ActionPerformed(evt);
            }
        });

        CheckMovesButton.setBackground(new java.awt.Color(255, 51, 153));
        CheckMovesButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        CheckMovesButton.setText("CECK MOVES");
        CheckMovesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMovesButtonActionPerformed(evt);
            }
        });

        ResetButton.setBackground(new java.awt.Color(0, 153, 0));
        ResetButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        ResetButton.setText("RESET");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        SolutionButton.setBackground(new java.awt.Color(0, 153, 153));
        SolutionButton.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        SolutionButton.setText("SOLUTION");
        SolutionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolutionButtonActionPerformed(evt);
            }
        });

        SelectionButton9.setBackground(new java.awt.Color(0, 0, 0));
        SelectionButton9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SelectionButton9.setForeground(new java.awt.Color(255, 255, 255));
        SelectionButton9.setText("9");
        SelectionButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionButton9ActionPerformed(evt);
            }
        });

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setPreferredSize(new java.awt.Dimension(126, 126));

        r7c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c6ActionPerformed(evt);
            }
        });

        r7c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c4ActionPerformed(evt);
            }
        });

        r7c5.setBackground(new java.awt.Color(204, 153, 255));
        r7c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r7c5.setText("5");
        r7c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r7c5ActionPerformed(evt);
            }
        });

        r8c4.setBackground(new java.awt.Color(204, 153, 255));
        r8c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c4.setText("9");
        r8c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c4ActionPerformed(evt);
            }
        });

        r8c5.setBackground(new java.awt.Color(204, 153, 255));
        r8c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c5.setText("6");
        r8c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c5ActionPerformed(evt);
            }
        });

        r8c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r8c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r8c6ActionPerformed(evt);
            }
        });

        r9c4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c4ActionPerformed(evt);
            }
        });

        r9c5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c5ActionPerformed(evt);
            }
        });

        r9c6.setBackground(new java.awt.Color(204, 153, 255));
        r9c6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        r9c6.setText("1");
        r9c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r9c6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(r7c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r7c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(r7c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(r8c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r8c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(r9c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r9c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r7c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r7c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r8c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r8c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r9c6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r9c4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ResetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UndoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SolutionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CheckMovesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton136))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SelectionButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectionButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SelectionButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectionButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(SelectionButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectionButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectionButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(SelectionButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SelectionButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectionButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectionButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton136)
                    .addComponent(CheckMovesButton)
                    .addComponent(SolutionButton)
                    .addComponent(UndoButton)
                    .addComponent(ResetButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void SelectionButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "2";
        chooseNumber(SelectionButton2);

    }                                                

    private void SelectionButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "1";
        chooseNumber(SelectionButton1);
    }                                                

    private void SelectionButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "4";
        chooseNumber(SelectionButton4);
    }                                                

    private void SelectionButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "3";
        chooseNumber(SelectionButton3);
    }                                                

    private void r5c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     

        r5c5.setBackground(white);
        r5c5.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r5c5,number);
        st.push(hm);
    }                                    

    private void SelectionButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "6";
        chooseNumber(SelectionButton6);
    }                                                

    private void r9c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
     
             
        r9c9.setBackground(white);
        r9c9.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r9c9,number);
        st.push(hm);
    }                                    

    private void r3c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r3c9.setBackground(white);
        r3c9.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r3c9,number);
        st.push(hm);

    }                                    

    private void r6c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        r6c9.setBackground(white);
        r6c9.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r6c9,number);
        st.push(hm);
    }                                    

    private void SelectionButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "5";
        chooseNumber(SelectionButton5);
    }                                                

    private void SelectionButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "7";
        chooseNumber(SelectionButton7);
    }                                                

    private void SelectionButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "8";
        chooseNumber(SelectionButton8);
    }                                                

    private void SelectionButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        number = "9";
        chooseNumber(SelectionButton9);
    }                                                

    private void r5c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
      
        r5c6.setBackground(white);
        r5c6.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r5c6,number);
        st.push(hm);
    }                                    

    private void r6c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r6c6.setBackground(white);
        r6c6.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r6c6,number);
        st.push(hm);
    }                                    

    private void r5c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
       r5c4.setBackground(white);
        r5c4.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r5c4,number);
        st.push(hm);
    }                                    

    private void r4c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r4c4.setBackground(white);
        r4c4.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r4c4,number);
        st.push(hm);
    }                                    

    private void r1c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r1c1.setBackground(white);
        r1c1.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r1c1,number);
        st.push(hm);
    }                                    

    private void r1c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
       r1c2.setBackground(white);
        r1c2.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r1c2,number);
        st.push(hm);
    }                                    

    private void r1c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
      
        r1c3.setBackground(white);
        r1c3.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r1c3,number);
        st.push(hm);
    }                                    

    private void r2c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
      r2c2.setBackground(white);
        r2c2.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r2c2,number);
        st.push(hm);
    }                                    

    private void r2c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
          
           
        r2c3.setBackground(white);
        r2c3.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r2c3,number);
        st.push(hm);
    }                                    

    private void r3c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
          
          
        r3c2.setBackground(white);
        r3c2.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r3c2,number);
        st.push(hm);
    }                                    

    private void r1c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
          
         
        r1c5.setBackground(white);
        r1c5.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r1c5,number);
        st.push(hm);
    }                                    

    private void r1c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r1c6.setBackground(white);
        r1c6.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r1c6,number);
        st.push(hm);
    }                                    

    private void r2c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r2c4.setBackground(white);
        r2c4.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r2c4,number);
        st.push(hm);
    }                                    

    private void r3c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r3c4.setBackground(white);
        r3c4.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r3c4,number);
        st.push(hm);
    }                                    

    private void r3c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r3c6.setBackground(white);
        r3c6.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r3c6,number);
        st.push(hm);
    }                                    

    private void r2c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r2c8.setBackground(white);
        r2c8.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r2c8,number);
        st.push(hm);
    }                                    

    private void r3c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r3c7.setBackground(white);
        r3c7.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r3c7,number);
        st.push(hm);
    }                                    

    private void r4c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r4c1.setBackground(white);
        r4c1.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r4c1,number);
        st.push(hm);
    }                                    

    private void r4c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r4c2.setBackground(white);
        r4c2.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r4c2,number);
        st.push(hm);
    }                                    

    private void r4c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r4c3.setBackground(white);
        r4c3.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r4c3,number);
        st.push(hm);
    }                                    

    private void r5c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r5c1.setBackground(white);
        r5c1.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r5c1,number);
        st.push(hm);
    }                                    

    private void r6c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r6c1.setBackground(white);
        r6c1.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r6c1,number);
        st.push(hm);
    }                                    

    private void r6c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        
        r6c3.setBackground(white);
        r6c3.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r6c3,number);
        st.push(hm);
    }                                    

    private void r4c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
      
        r4c7.setBackground(white);
        r4c7.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r4c7,number);
        st.push(hm);
    }                                    

    private void r4c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
     
        r4c9.setBackground(white);
        r4c9.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r4c9,number);
        st.push(hm);
    }                                    

    private void r5c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
      
     
        r5c9.setBackground(white);
        r5c9.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r5c9,number);
        st.push(hm);
    }                                    

    private void r6c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
     
        r6c7.setBackground(white);
        r6c7.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r6c7,number);
        st.push(hm);
    }                                    

    private void r6c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        r6c8.setBackground(white);
        r6c8.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r6c8,number);
        st.push(hm);
    }                                    

    private void r7c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r7c1.setBackground(white);
        r7c1.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r7c1,number);
        st.push(hm);
    }                                    

    private void r7c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
      
        r7c3.setBackground(white);
        r7c3.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r7c3,number);
        st.push(hm);
    }                                    

    private void r8c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
       r8c2.setBackground(white);
        r8c2.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r8c2,number);
        st.push(hm);
    }                                    

    private void r8c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
      
       r8c3.setBackground(white);
        r8c3.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r8c3,number);
        st.push(hm);
    }                                    

    private void r7c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
     r7c4.setBackground(white);
        r7c4.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r7c4,number);
        st.push(hm);
    }                                    

    private void r7c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r7c6.setBackground(white);
        r7c6.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r7c6,number);
        st.push(hm);
    }                                    

    private void r8c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r8c6.setBackground(white);
        r8c6.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r8c6,number);
        st.push(hm);
    }                                    

    private void r9c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
      
       r9c4.setBackground(white);
        r9c4.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r9c4,number);
        st.push(hm);
    }                                    

    private void r9c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
       r9c5.setBackground(white);
        r9c5.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r9c5,number);
        st.push(hm);
    }                                    

    private void r7c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r7c8.setBackground(white);
        r7c8.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r7c8,number);
        st.push(hm);
    }                                    

    private void r8c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r8c7.setBackground(white);
        r8c7.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r8c7,number);
        st.push(hm);
    }                                    

    private void r8c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
             
        r8c8.setBackground(white);
        r8c8.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r8c8,number);
        st.push(hm);
    }                                    

    private void r9c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
        r9c7.setBackground(white);
        r9c7.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r9c7,number);
        st.push(hm);
    }                                    

    private void r9c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
             
        r9c8.setBackground(white);
        r9c8.setText(number);
        HashMap<JButton,String>hm = new HashMap<JButton,String>();
        hm.put(r9c8,number);
        st.push(hm);
    }                                    

    private void r4c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r4c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r6c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r6c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r4c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r5c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r5c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r5c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r5c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r6c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r7c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r8c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r9c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r9c2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r9c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r7c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r8c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r8c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r9c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r7c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r7c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r8c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r1c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r1c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r1c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
      
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c7ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c9ActionPerformed(java.awt.event.ActionEvent evt) {                                     
       
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r3c8ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r1c4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c6ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r3c5ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r2c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r3c1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void r3c3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
      
         JOptionPane.showMessageDialog(this,"This place is already been allocated","Sudoku game",JOptionPane.INFORMATION_MESSAGE);
    }                                    

    private void jButton136ActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
        JFrame frame = new JFrame("Exit");
       if(JOptionPane.showConfirmDialog(frame,"confirm if you want to Exit","Sudoku Game",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
           
           System.exit(0);
       }
    }                                          

    private void SolutionButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        seeSolution();
    }                                              

    private void CheckMovesButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        
        CheckMoves();
    }                                                

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        resetGame();
    }                                           

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Undo();
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_FRAME2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_FRAME2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_FRAME2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SUDOKU_FRAME2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SUDOKU_FRAME2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton CheckMovesButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SelectionButton1;
    private javax.swing.JButton SelectionButton2;
    private javax.swing.JButton SelectionButton3;
    private javax.swing.JButton SelectionButton4;
    private javax.swing.JButton SelectionButton5;
    private javax.swing.JButton SelectionButton6;
    private javax.swing.JButton SelectionButton7;
    private javax.swing.JButton SelectionButton8;
    private javax.swing.JButton SelectionButton9;
    private javax.swing.JButton SolutionButton;
    private javax.swing.JButton UndoButton;
    private javax.swing.JButton jButton136;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton r1c1;
    private javax.swing.JButton r1c2;
    private javax.swing.JButton r1c3;
    private javax.swing.JButton r1c4;
    private javax.swing.JButton r1c5;
    private javax.swing.JButton r1c6;
    private javax.swing.JButton r1c7;
    private javax.swing.JButton r1c8;
    private javax.swing.JButton r1c9;
    private javax.swing.JButton r2c1;
    private javax.swing.JButton r2c2;
    private javax.swing.JButton r2c3;
    private javax.swing.JButton r2c4;
    private javax.swing.JButton r2c5;
    private javax.swing.JButton r2c6;
    private javax.swing.JButton r2c7;
    private javax.swing.JButton r2c8;
    private javax.swing.JButton r2c9;
    private javax.swing.JButton r3c1;
    private javax.swing.JButton r3c2;
    private javax.swing.JButton r3c3;
    private javax.swing.JButton r3c4;
    private javax.swing.JButton r3c5;
    private javax.swing.JButton r3c6;
    private javax.swing.JButton r3c7;
    private javax.swing.JButton r3c8;
    private javax.swing.JButton r3c9;
    private javax.swing.JButton r4c1;
    private javax.swing.JButton r4c2;
    private javax.swing.JButton r4c3;
    private javax.swing.JButton r4c4;
    private javax.swing.JButton r4c5;
    private javax.swing.JButton r4c6;
    private javax.swing.JButton r4c7;
    private javax.swing.JButton r4c8;
    private javax.swing.JButton r4c9;
    private javax.swing.JButton r5c1;
    private javax.swing.JButton r5c2;
    private javax.swing.JButton r5c3;
    private javax.swing.JButton r5c4;
    private javax.swing.JButton r5c5;
    private javax.swing.JButton r5c6;
    private javax.swing.JButton r5c7;
    private javax.swing.JButton r5c8;
    private javax.swing.JButton r5c9;
    private javax.swing.JButton r6c1;
    private javax.swing.JButton r6c2;
    private javax.swing.JButton r6c3;
    private javax.swing.JButton r6c4;
    private javax.swing.JButton r6c5;
    private javax.swing.JButton r6c6;
    private javax.swing.JButton r6c7;
    private javax.swing.JButton r6c8;
    private javax.swing.JButton r6c9;
    private javax.swing.JButton r7c1;
    private javax.swing.JButton r7c2;
    private javax.swing.JButton r7c3;
    private javax.swing.JButton r7c4;
    private javax.swing.JButton r7c5;
    private javax.swing.JButton r7c6;
    private javax.swing.JButton r7c7;
    private javax.swing.JButton r7c8;
    private javax.swing.JButton r7c9;
    private javax.swing.JButton r8c1;
    private javax.swing.JButton r8c2;
    private javax.swing.JButton r8c3;
    private javax.swing.JButton r8c4;
    private javax.swing.JButton r8c5;
    private javax.swing.JButton r8c6;
    private javax.swing.JButton r8c7;
    private javax.swing.JButton r8c8;
    private javax.swing.JButton r8c9;
    private javax.swing.JButton r9c1;
    private javax.swing.JButton r9c2;
    private javax.swing.JButton r9c3;
    private javax.swing.JButton r9c4;
    private javax.swing.JButton r9c5;
    private javax.swing.JButton r9c6;
    private javax.swing.JButton r9c7;
    private javax.swing.JButton r9c8;
    private javax.swing.JButton r9c9;
    // End of variables declaration                   
}
