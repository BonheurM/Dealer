package dealerHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dealerPD.Car;
import dealerPD.Dealer;
import dealerPD.SalesPerson;
import jakarta.persistence.EntityTransaction;

import javax.swing.JLabel;
import javax.swing.JTextField;

import dealerDAO.emDAO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class CarEdit extends JPanel {
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField textField_4;
  private JTextField textField_5;
  private JComboBox comboBox;
  private JTextField textField_6;

  /**
   * Create the panel.
   */
  public CarEdit(JFrame currentFrame, Dealer dealer, Car car, Boolean isAdd) {
    DateTimeFormatter dateFormater= DateTimeFormatter.ofPattern("M/d/yyyy");
    if(emDAO.getEM().contains(car))
    	emDAO.getEM().refresh(car );
    setLayout(null);
    
    JLabel lblCarEdit = new JLabel("Car Edit");
    lblCarEdit.setBounds(180, 27, 61, 16);
    add(lblCarEdit);
    
    JLabel lblMake = new JLabel("Make : ");
    lblMake.setBounds(35, 60, 61, 16);
    add(lblMake);
    
    textField = new JTextField(car.getMake());
    textField.setBounds(145, 55, 130, 26);
    add(textField);
    textField.setColumns(10);
    
    JLabel lblModel = new JLabel("Model :");
    lblModel.setBounds(35, 88, 61, 16);
    add(lblModel);
    
    textField_1 = new JTextField(car.getModel());
    textField_1.setBounds(145, 83, 130, 26);
    add(textField_1);
    textField_1.setColumns(10);
    
    JLabel lblYear = new JLabel("Year :");
    lblYear.setBounds(35, 116, 61, 16);
    add(lblYear);
    
    textField_2 = new JTextField(car.getYear());
    textField_2.setBounds(145, 111, 130, 26);
    add(textField_2);
    textField_2.setColumns(10);
    
    JLabel lblSerialNumber = new JLabel("Serial Number");
    lblSerialNumber.setBounds(36, 144, 97, 16);
    add(lblSerialNumber);
    
    textField_3 = new JTextField(car.getSerialNumber());
    textField_3.setBounds(145, 139, 130, 26);
    add(textField_3);
    textField_3.setColumns(10);
    
    JLabel lblDatePurchased = new JLabel("Date Purchased :");
    lblDatePurchased.setBounds(35, 187, 98, 16);
    add(lblDatePurchased);
    
    String date = null;
    if (car.getDatePurchased() != null) date = car.getDatePurchased().format(dateFormater);
    textField_4 = new JTextField(date);
    textField_4.setBounds(145, 183, 130, 26);
    add(textField_4);
    textField_4.setColumns(10);
    
    JLabel lblDateSold = new JLabel("Date Sold :");
    lblDateSold.setBounds(35, 214, 98, 16);
    add(lblDateSold);
    
    date = null;
    if (car.getDateSold() != null) date = car.getDateSold().format(dateFormater);
    textField_5 = new JTextField(date);
    textField_5.setBounds(145, 209, 130, 26);
    add(textField_5);
    textField_5.setColumns(10);
    
    JLabel lblSalesperson = new JLabel("SalesPerson :");
    lblSalesperson.setBounds(35, 241, 98, 16);
    add(lblSalesperson);
    
    comboBox = new JComboBox();
    comboBox.addItem(null);
    for (SalesPerson salesPerson : dealer.getSalesPersons())
      comboBox.addItem(salesPerson);
    comboBox.setBounds(145, 237, 130, 27);
    comboBox.setSelectedItem(car.getSalesPerson());
    add(comboBox);
    
    JButton btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  EntityTransaction userTransaction = emDAO.getEM().getTransaction();
    		userTransaction.begin(); 
        car.setMake(textField.getText());
        car.setModel(textField_1.getText());
        car.setYear(textField_2.getText());
        car.setSerialNumber(textField_3.getText());
        car.setPrice(new BigDecimal(textField_6.getText()));
       
        if (!textField_4.getText().isEmpty()) car.setDatePurchased(LocalDate.parse(textField_4.getText(), dateFormater));
        if (!textField_5.getText().isEmpty())car.setDateSold(LocalDate.parse(textField_5.getText(), dateFormater));
        car.setSalesPerson((SalesPerson) comboBox.getSelectedItem()); 
        if (isAdd) dealer.addCar(car);
        userTransaction.commit(); 
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new CarSelection(currentFrame,dealer));
        currentFrame.getContentPane().revalidate();
      }
    });
    btnSave.setBounds(89, 266, 117, 29);
    add(btnSave);
    
    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new CarSelection(currentFrame,dealer));
        currentFrame.getContentPane().revalidate();
      }
    });
    btnCancel.setBounds(242, 266, 117, 29);
    add(btnCancel);
    
    JLabel lblPrice = new JLabel("Price :");
    lblPrice.setBounds(35, 165, 61, 16);
    add(lblPrice);
    
    textField_6 = new JTextField();
    if (car.getPrice() != null) textField_6.setText(car.getPrice().toString());
    textField_6.setBounds(145, 162, 130, 26);
    add(textField_6);
    textField_6.setColumns(10);

  }
}