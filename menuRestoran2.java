import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.HashMap; 
import java.util.Map; 

public class menuRestoran2 {
    private static JPanel orderedItemPanel; 
    private static JPanel totalHargaPanel; 
    private static JLabel totalHargaLabel; 
    private static JTextArea catatanTextArea; 
    private static Map<String, Integer> orderCountMap = new HashMap<>(); 
    private static Map<String, Integer> hargaMakanan = new HashMap<>();
    private static Map<String, Integer> hargaMinuman = new HashMap<>();
    private static Map<String, Integer> hargaSnack = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Restoran");
        frame.setLayout(new BorderLayout());


        JPanel headerJPanel = new JPanel();
        headerJPanel.setPreferredSize(new Dimension(800, 100)); 
        headerJPanel.setBackground(new Color(0xFFB53D)); 
        headerJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        headerJPanel.setLayout(new BorderLayout());


        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(100, 100)); 
        logoPanel.setBackground(Color.WHITE); 
        logoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 

        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon("Logo.jpg"); 
        Image logoImage = logoIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); 
        logoLabel.setIcon(new ImageIcon(logoImage));
        logoPanel.add(logoLabel);

        headerJPanel.add(logoPanel, BorderLayout.WEST);


        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(600, 100)); 
        infoPanel.setBackground(new Color(0xFFB53D)); 
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); 

        
        JLabel infoLabel = new JLabel("PANDAWA DINER");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        JLabel addressLabel = new JLabel("Alamat: Sepanjang Jalan Kenangan");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        JLabel emailLabel = new JLabel("Email: info@restorankeluarga.com");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        infoPanel.add(Box.createVerticalStrut(10)); 
        infoPanel.add(infoLabel);
        infoPanel.add(Box.createVerticalStrut(10)); 
        infoPanel.add(addressLabel);
        infoPanel.add(Box.createVerticalStrut(5)); 
        infoPanel.add(emailLabel);
        infoPanel.add(Box.createVerticalStrut(10)); 

        headerJPanel.add(infoPanel, BorderLayout.CENTER);


        JPanel tableNumberPanel = new JPanel();
        tableNumberPanel.setPreferredSize(new Dimension(100, 100)); 
        tableNumberPanel.setBackground(Color.WHITE); 
        tableNumberPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        tableNumberPanel.setLayout(new BoxLayout(tableNumberPanel, BoxLayout.Y_AXIS)); 

        
        JLabel tableLabel = new JLabel("Meja");
        tableLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tableLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        JLabel tableNumberLabel = new JLabel("??");
        tableNumberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tableNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        tableNumberPanel.add(Box.createVerticalStrut(10)); 
        tableNumberPanel.add(tableLabel);
        tableNumberPanel.add(Box.createVerticalStrut(10)); 
        tableNumberPanel.add(tableNumberLabel);

        headerJPanel.add(tableNumberPanel, BorderLayout.EAST);


        JPanel bodyJPanel = new JPanel();
        bodyJPanel.setLayout(new BorderLayout()); 
        bodyJPanel.setPreferredSize(new Dimension(800, 500)); 
        bodyJPanel.setBackground(Color.WHITE); 

        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(600, 400)); 
        menuPanel.setBackground(Color.LIGHT_GRAY); 
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        menuPanel.setLayout(new BorderLayout());

        JPanel menuLabelPanel = new JPanel();
        menuLabelPanel.setBackground(Color.WHITE);
        menuLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
        menuLabelPanel.setPreferredSize(new Dimension(600, 50)); 
        
        JLabel menuLabel = new JLabel("Daftar Menu");
        menuLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        menuLabelPanel.add(menuLabel);
        
        menuPanel.add(menuLabelPanel, BorderLayout.NORTH);

        JPanel menuItemPanel = new JPanel();
        menuItemPanel.setBackground(Color.WHITE);
        menuItemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
        menuItemPanel.setLayout(new GridLayout(0, 3, 10, 10));
        menuItemPanel.setPreferredSize(new Dimension(578, 2000));
        
        String[] makanan = {"Ayam Bakar", "Bakso", "Gulai Kambing", "Lasagna", "Mie Ayam", "Mie Goreng", "Nasi Goreng", "Nasi Kebuli", "Sate Ayam", "Sate Kelinci", "Sop Iga", "Steak Ayam"};
        String[] minuman = {"Air Mineral", "Es Buah", "Es Dawet", "Es Degan", "Es Doger", "Es Jeruk", "Es Kolak", "Es Kuwud", "Es Teh", "Jus Mangga", "Kopi", "Susu Coklat"};
        String[] snack = {"Croissant", "Dimsum", "Donat", "French Fries", "Keripik Kentang", "Martabak Mini", "Mendoan", "Nugget", "Pisang Goreng", "Singkong Goreng", "Sushi", "Tahu Crispy"};
        
        hargaMakanan.put("Ayam Bakar", 30000);
        hargaMakanan.put("Bakso", 15000);
        hargaMakanan.put("Gulai Kambing", 35000);
        hargaMakanan.put("Lasagna", 50000);
        hargaMakanan.put("Mie Ayam", 20000);
        hargaMakanan.put("Mie Goreng", 22000);
        hargaMakanan.put("Nasi Goreng", 25000);
        hargaMakanan.put("Nasi Kebuli", 27000);
        hargaMakanan.put("Sate Ayam", 18000);
        hargaMakanan.put("Sate Kelinci", 40000);
        hargaMakanan.put("Sop Iga", 40000);
        hargaMakanan.put("Steak Ayam", 60000);
        
        hargaMinuman.put("Air Mineral", 4000);
        hargaMinuman.put("Es Buah", 12000);
        hargaMinuman.put("Es Dawet", 8000);
        hargaMinuman.put("Es Degan", 8000);
        hargaMinuman.put("Es Doger", 10000);
        hargaMinuman.put("Es Jeruk", 6000);
        hargaMinuman.put("Es Kolak", 7000);
        hargaMinuman.put("Es Kuwud", 9000);
        hargaMinuman.put("Es Teh", 5000);
        hargaMinuman.put("Jus Mangga", 15000);
        hargaMinuman.put("Kopi", 15000);
        hargaMinuman.put("Susu Coklat", 12000);
        
        hargaSnack.put("Croissant", 10000);
        hargaSnack.put("Dimsum", 20000);
        hargaSnack.put("Donat", 7000);
        hargaSnack.put("French Fries", 15000);
        hargaSnack.put("Keripik Kentang", 8000);
        hargaSnack.put("Martabak Mini", 15000);
        hargaSnack.put("Mendoan", 7000);
        hargaSnack.put("Nugget", 12000);
        hargaSnack.put("Pisang Goreng", 5000);
        hargaSnack.put("Singkong Goreng", 8000);
        hargaSnack.put("Sushi", 25000);
        hargaSnack.put("Tahu Crispy", 10000);
        
        addMenuItems(menuItemPanel, makanan, Color.LIGHT_GRAY, "makanan/", hargaMakanan);
        addMenuItems(menuItemPanel, minuman, Color.LIGHT_GRAY, "minuman/", hargaMinuman);
        addMenuItems(menuItemPanel, snack, Color.LIGHT_GRAY, "snack/", hargaSnack);
        
        JScrollPane scrollPane = new JScrollPane(menuItemPanel);
        scrollPane.setPreferredSize(new Dimension(600, 300)); 
        
        menuPanel.add(scrollPane, BorderLayout.CENTER);


        
        JPanel pesananPanel = new JPanel();
        pesananPanel.setPreferredSize(new Dimension(200, 400)); 
        pesananPanel.setBackground(Color.BLUE); 
        pesananPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        pesananPanel.setLayout(new BorderLayout());

        JPanel pesananLabelPanel = new JPanel();
        pesananLabelPanel.setBackground(new Color(0xFFB53D)); 
        pesananLabelPanel.setPreferredSize(new Dimension(200, 50)); 
        pesananLabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
        
        JLabel pesananLabel = new JLabel("Pesanan Anda");
        pesananLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        pesananLabel.setForeground(Color.BLACK); 
        pesananLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        pesananLabelPanel.add(pesananLabel);
        
        pesananPanel.add(pesananLabelPanel, BorderLayout.NORTH);

        orderedItemPanel = new JPanel();
        orderedItemPanel.setBackground(Color.WHITE);
        orderedItemPanel.setLayout(new BoxLayout(orderedItemPanel, BoxLayout.Y_AXIS)); 
        orderedItemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JScrollPane orderedItemScrollPane = new JScrollPane(orderedItemPanel);
        orderedItemScrollPane.setPreferredSize(new Dimension(200, 400));
        orderedItemScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        pesananPanel.add(orderedItemScrollPane, BorderLayout.CENTER);

        totalHargaPanel = new JPanel();
        totalHargaPanel.setBackground(Color.WHITE);
        totalHargaPanel.setLayout(new BorderLayout());
        totalHargaPanel.setPreferredSize(new Dimension(200,125));
        
        totalHargaLabel = new JLabel("Total Harga: Rp. 0", SwingConstants.CENTER);
        
        totalHargaPanel.add(totalHargaLabel, BorderLayout.NORTH);

        
        JPanel catatanPanel = new JPanel();
            catatanPanel.setLayout(new BorderLayout());
            catatanPanel.setPreferredSize(new Dimension(200,50));
            catatanPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        JLabel catatanLabel = new JLabel("Catatan:");
            catatanTextArea = new JTextArea(3, 20);
            catatanTextArea.setLineWrap(true);
            catatanTextArea.setWrapStyleWord(true);
        
        catatanPanel.add(catatanLabel, BorderLayout.NORTH);
        
        catatanPanel.add(new JScrollPane(catatanTextArea), BorderLayout.CENTER);
        
        totalHargaPanel.add(catatanPanel, BorderLayout.CENTER);
        
        JButton enterButton = new JButton("Enter");
        enterButton.setBackground(new Color(0x2F65DA));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFont(new Font("Arial", Font.BOLD, 14));
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (orderCountMap.isEmpty() || orderCountMap.values().stream().allMatch(count -> count == 0)) {
                JOptionPane.showMessageDialog(frame, "Pesanan kosong. Silahkan pilih menu.", "Pesanan Kosong", JOptionPane.WARNING_MESSAGE);
                return; 
                }
                
                StringBuilder pesananDetail = new StringBuilder("Detail Pesanan:\n");
                int totalHarga = 0;
                
                for (Map.Entry<String, Integer> entry : orderCountMap.entrySet()) {
                    String item = entry.getKey();
                    int count = entry.getValue();
                    if (count > 0) {
                        int harga = getPrice(item);
                        pesananDetail.append(item).append(" ").append(count).append(" - Rp. ").append(harga * count).append("\n");
                        totalHarga += harga * count;
                    }
                }
                String catatan = catatanTextArea.getText().trim();
                if (!catatan.isEmpty()) {
                    pesananDetail.append("\nCatatan: ").append(catatan);
                }
        
                
                pesananDetail.append("\nTotal Harga: Rp. ").append(totalHarga);
                int option = JOptionPane.showConfirmDialog(frame, pesananDetail.toString(), "Konfirmasi Pesanan", JOptionPane.YES_NO_OPTION);                
                if (option == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Pesanan sudah dipesan. Tolong tunggu.");
                    orderCountMap.clear(); 
                    updateOrderPanel(); 
                    ((JLabel) totalHargaPanel.getComponent(0)).setText("Total Harga: Rp. 0"); 
                    catatanTextArea.setText(""); 
                }
        
                
                pesananDetail.append("\nTotal Harga: Rp. ").append(totalHarga);
            }
        });
        
        totalHargaPanel.add(enterButton, BorderLayout.SOUTH);
        
        pesananPanel.add(totalHargaPanel, BorderLayout.SOUTH);

        bodyJPanel.add(scrollPane, BorderLayout.WEST); 
        bodyJPanel.add(pesananPanel, BorderLayout.EAST); 


        JPanel footerJPanel = new JPanel();
        footerJPanel.setLayout(new BoxLayout(footerJPanel, BoxLayout.Y_AXIS)); 
        footerJPanel.setPreferredSize(new Dimension(800, 50)); 
        footerJPanel.setBackground(new Color(0xFFB53D));
        footerJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        
        JLabel footerJLabel = new JLabel("Menyajikan Kenikmatan di Setiap Hidangan");
        footerJLabel.setFont(new Font("Arial", Font.BOLD, 14));
        footerJLabel.setForeground(Color.BLACK); 
        footerJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        footerJPanel.add(Box.createVerticalGlue()); 
        footerJPanel.add(footerJLabel);
        footerJPanel.add(Box.createVerticalGlue()); 


        frame.add(headerJPanel, BorderLayout.NORTH);
        frame.add(bodyJPanel, BorderLayout.CENTER);
        frame.add(footerJPanel, BorderLayout.SOUTH);


        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private static void addMenuItems(JPanel menuItemPanel, String[] items, Color color, String imageFolder, Map<String, Integer> hargaMap) {
        for (String item : items) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setBackground(color);
            
            JLabel label = new JLabel(item);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            ImageIcon imageIcon = new ImageIcon(imageFolder + item.toLowerCase().replaceAll(" ", "_") + ".jpg");
            Image image = imageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            JLabel imageLabel = new JLabel(imageIcon);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            int harga = hargaMap.get(item);
            JLabel priceLabel = new JLabel("Rp. " + harga);
            priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
            buttonPanel.setBackground(color);

            JButton addButton = new JButton("+");
            addButton.setPreferredSize(new Dimension(50, 18));
            addButton.setFont(new Font("Verdana", Font.BOLD, 16));
            addButton.setBackground(new Color(0xFFA70F));
            addButton.setForeground(Color.BLACK);
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addItemToOrder(item, harga);
                    updateTotalPrice();
                }
            });

            JButton removeButton = new JButton("-");
            removeButton.setPreferredSize(new Dimension(50, 18));
            removeButton.setFont(new Font("Verdana", Font.BOLD, 20));
            removeButton.setBackground(Color.RED);
            removeButton.setForeground(Color.WHITE);
            
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeItemFromOrder(item, harga);
                    updateTotalPrice();
                }
            });

            buttonPanel.add(addButton);
            buttonPanel.add(removeButton);

            itemPanel.add(label);
            itemPanel.add(imageLabel);
            itemPanel.add(priceLabel);
            itemPanel.add(buttonPanel);

            menuItemPanel.add(itemPanel);
        }
    }

    private static void addItemToOrder(String item, int harga) {
        orderCountMap.put(item, orderCountMap.getOrDefault(item, 0) + 1);
        updateOrderPanel();
    }

    private static void removeItemFromOrder(String item, int harga) {
        if (orderCountMap.containsKey(item) && orderCountMap.get(item) > 0) {
            orderCountMap.put(item, orderCountMap.get(item) - 1);
        }
        updateOrderPanel();
    }

    private static void updateOrderPanel() {
        orderedItemPanel.removeAll();

        for (Map.Entry<String, Integer> entry : orderCountMap.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                int harga = getPrice(item);
                orderedItemPanel.add(new JLabel(item + " " + count + " = Rp. " + (harga * count)));
            }
        }

        orderedItemPanel.revalidate();
        orderedItemPanel.repaint();
    }

    private static void updateTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> entry : orderCountMap.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            if (count > 0) {
                int harga = getPrice(item);
                totalPrice += harga * count;
            }
        }

        
        totalHargaLabel.setText("Total Harga: Rp. " + totalPrice);
    }
    private static int getPrice(String item) {
        if (hargaMakanan.containsKey(item)) {
            return hargaMakanan.get(item);
        } else if (hargaMinuman.containsKey(item)) {
            return hargaMinuman.get(item);
        } else if (hargaSnack.containsKey(item)) {
            return hargaSnack.get(item);
        }
        return 0;
    }
}