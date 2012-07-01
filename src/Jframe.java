import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;




public class Jframe extends JFrame {


	private JMenuBar jMenuBar1 = new JMenuBar();

	private JMenu jMenu1 = new JMenu();
	private JMenu jMenu2 = new JMenu();
	private JMenu jMenu3 = new JMenu();

	private JMenuItem newPaint = new JMenuItem();
	private JMenuItem openPaint = new JMenuItem();
	private JMenuItem savePaint = new JMenuItem();
	private JMenuItem printPaint = new JMenuItem();
	private JMenuItem exit = new JMenuItem();
	private JMenuItem setOption = new JMenuItem();
	private JMenuItem about = new JMenuItem();

	private JCheckBoxMenuItem  quality = new  JCheckBoxMenuItem ();

	private JPanel panelWest = new JPanel();
	private JPanel jPanel1 = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JPanel jPanel4 = new JPanel();
	private JPanel jPanel5 = new JPanel();
	private JPanel jPanel6 = new JPanel();
	private JLabel jLabel1 = new JLabel();
	private	JPanel jPanel7 = new JPanel();
	private JPanel jPanel8 = new JPanel();

	private BorderLayout borderLayout1 = new BorderLayout();
	private BorderLayout borderLayout2 = new BorderLayout();
	private BorderLayout borderLayout3 = new BorderLayout();

	private GridLayout gridLayout2 = new GridLayout();
	private GridLayout gridLayout3 = new GridLayout();
	private GridLayout gridLayout4 = new GridLayout();
	private GridLayout gridLayout5 = new GridLayout();

	private Border border1 = BorderFactory.createEtchedBorder();
	private TitledBorder titledBorder1 = new TitledBorder(border1,"Colore");
	private Border border3 = BorderFactory.createEtchedBorder();
	private TitledBorder titledBorder3 = new TitledBorder(border3,"Riempimento");
	private Border border4 = BorderFactory.createEtchedBorder();
	private TitledBorder titledBorder4 = new TitledBorder(border4,"Figure Geometriche");
	private Border border5 = BorderFactory.createEtchedBorder();
	private TitledBorder titledBorder5 = new TitledBorder(border5,"Strumento");

	private JRadioButton circle = new JRadioButton();
	private JRadioButton square = new JRadioButton();
	private JRadioButton star = new JRadioButton();
	private JRadioButton both = new JRadioButton();
	private JRadioButton empty = new JRadioButton();
	private JRadioButton full = new JRadioButton();
	private JRadioButton pen = new JRadioButton();
	private JRadioButton eraser = new JRadioButton();

	private JButton color = new JButton();
	private JButton okAboutDialog = new JButton();
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JButton jButton4 = new JButton();
	private JCheckBox randomColor = new JCheckBox();

	private JComboBox<Integer> size = new JComboBox<Integer>();

	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private ButtonGroup buttonGroup2 = new ButtonGroup();
	private ArrayList<ShapeP> shapes;

	private static Paint paint;
	private ShapeP waitArea;
	private JFileChooser chooser=new JFileChooser();
	public static Jframe frame = new Jframe();
	private Creator creator;




	private Jframe() {

		initFrame();

	}

	private void initFrame() {

		// Imposto l'operazione da effettuare al tentativo di chiusura del frame
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		// Imposto il titolo
		this.setTitle("MiniPainter");
		// Imposto la dimensione
		//this.setSize(600, 600);
		// Imposto l'icona
		this.setIconImage(new ImageIcon("MiniPainter.jpg").getImage());
		//creo la classe paint
		paint = new Paint();
		shapes = new ArrayList<ShapeP>();
		creator = new ConcreteCreator();
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")+File.separator+"MiniPainter"));
		creator = new ConcreteCreator();
		Toolkit toolkit=Toolkit.getDefaultToolkit();

		//Recupero l'immagine del cursore custom tramite il Toolkit
		Image img=toolkit.getImage("cursor.gif");

		//Attendo finche' l'immagine non e' stata completamente caricata
		MediaTracker tracker=new MediaTracker(this);
		tracker.addImage(img,0);
		try {tracker.waitForID(0);} catch (InterruptedException e) {}

		//Creo il cursore custom
		Cursor custom=toolkit.createCustomCursor(img,new Point(3,29),"");
		//Imposto il cursore custom come cursor del pannello su cui disegno
		paint.setCursor(custom);

		this.addWindowListener(new WListener());
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelWest);
		panelWest.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 70, Short.MAX_VALUE)
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
				);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(paint);
		paint.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 314, Short.MAX_VALUE)
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 257, Short.MAX_VALUE)
				);



		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(panelWest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(paint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(panelWest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(paint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);

		pack();


		//setto i nomi dei menu
		jMenu1.setText("File");
		newPaint.setText("Nuovo");
		openPaint.setText("Apri");
		savePaint.setText("Salva");
		printPaint.setText("Stampa");
		exit.setText("Esci");
		jMenu2.setText("Opzioni");
		setOption.setText("Dimensioni guide");
		jMenu3.setText("Aiuto");
		about.setText("Informazioni su...");
		quality.setText("Qualita'");
		quality.setSelected(true);

		color.setBackground(Color.black);
		color.setForeground(Color.white);
		color.setText("colore");
		randomColor.setText("Random");

		circle.setSelected(true);
		circle.setText("Cerchi");
		square.setText("Quadrati");
		star.setText("Stelline");
		buttonGroup1.add(circle);
		buttonGroup1.add(square);
		buttonGroup1.add(star);
		jLabel1.setText("Dimensione");
		for (int i=5;i<50;i++) size.addItem(new Integer(i));
		size.setSelectedIndex(0);

		pen.setText("penna");
		eraser.setText("gomma");
		both.setText("Entrambi");
		empty.setText("Vuoto");
		full.setSelected(true);
		full.setText("Pieno");
		buttonGroup2.add(both);
		buttonGroup2.add(empty);
		buttonGroup2.add(full);
		buttonGroup1.add(pen);
		buttonGroup1.add(eraser);

		jButton1.setText("Ellisse");
		jButton2.setText("Rettangolo");
		jButton3.setText("Linea");
		jButton4.setText("Curva");;
		//Compongo la GUI
		this.setJMenuBar(jMenuBar1);
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenu2);
		jMenuBar1.add(jMenu3);
		jMenu1.add(newPaint);
		jMenu1.add(openPaint);
		jMenu1.add(savePaint);
		jMenu1.add(printPaint);
		jMenu1.add(exit);
		jMenu2.add(setOption);
		jMenu2.add(quality);
		jMenu3.add(about);

		panelWest.setLayout(new BorderLayout());
		panelWest.add(jPanel1,BorderLayout.NORTH);
		panelWest.add(jPanel7,BorderLayout.CENTER);
		jPanel1.setLayout(borderLayout1);
		jPanel7.setLayout(borderLayout3);
		jPanel1.add(jPanel2,BorderLayout.NORTH);
		jPanel2.setLayout(gridLayout2);
		jPanel2.setBorder(titledBorder5);
		gridLayout2.setRows(6);
		jPanel2.add(eraser);
		jPanel2.add(pen);
		jPanel2.add(circle);
		jPanel2.add(square);
		jPanel2.add(star);
		jPanel2.add(jPanel4);
		jPanel4.setLayout(borderLayout2);
		jPanel4.add(jLabel1,BorderLayout.WEST);
		jPanel4.add(size,BorderLayout.CENTER);
		jPanel1.add(jPanel5,BorderLayout.SOUTH);
		jPanel5.setLayout(gridLayout3);
		jPanel5.setBorder(titledBorder3);
		gridLayout3.setRows(3);
		jPanel5.add(full);
		jPanel5.add(empty);
		jPanel5.add(both);
		jPanel7.add(jPanel6,BorderLayout.NORTH);
		jPanel6.setLayout(gridLayout4);
		jPanel6.setBorder(titledBorder1);
		gridLayout4.setRows(3);
		jPanel6.add(color);
		jPanel6.add(randomColor);
		jPanel7.add(jPanel8, BorderLayout.CENTER);
		jPanel8.setLayout(gridLayout5);
		jPanel8.setBorder(titledBorder4);
		gridLayout5.setRows(4);
		jPanel8.add(jButton1);
		jPanel8.add(jButton2);
		jPanel8.add(jButton3);
		jPanel8.add(jButton4);

	}
	/*public Graphics getGraphic() {
		return this.getGraphic();
	}*/
	public static Jframe getFrame() {
		return frame;
	}
	public void setKeyListener(KeyListener1 listener) {
		this.setFocusable(true);
		this.addKeyListener(listener);
	}
	public void setActionListener(ActionListener1 listener) {
		newPaint.addActionListener(listener);
		openPaint.addActionListener(listener);
		savePaint.addActionListener(listener);
		printPaint.addActionListener(listener);
		setOption.addActionListener(listener);
		exit.addActionListener(listener);
		about.addActionListener(listener);
		quality.addActionListener(listener);

		okAboutDialog.addActionListener(listener);

		color.addActionListener(listener);
		randomColor.addActionListener(listener);

		circle.addActionListener(listener);
		square.addActionListener(listener);
		star.addActionListener(listener);
		size.addActionListener(listener);
		pen.addActionListener(listener);
		eraser.addActionListener(listener);

		jButton1.addActionListener(listener);

		jButton2.addActionListener(listener);
		jButton3.addActionListener(listener);
		jButton4.addActionListener(listener);
		both.addActionListener(listener);
		full.addActionListener(listener);
		empty.addActionListener(listener);


	}
	public void setMouseListener(MouseListener1 listener) {
		this.addMouseListener(listener);
	}
	public void setMouseMotionListener(MouseMotionListener1 listener) {
		this.addMouseMotionListener(listener);
	}
	public Paint getPaint() {

		return paint;
	}
	private class WListener extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			paint.exit();
		}
	}

	@SuppressWarnings("serial")
	private class Paint extends JPanel implements Observer {
		//dimensioni guide
		private  int sizeS = 15;
		//booleano per verificare se il disegno è stato salvato
		private boolean isSaved;
		//numero strumento che l'utente ha selezionato
		private int NStrumento;
		//forma attualmente selezionata per il drag
		private ShapeP selectedShape;
		//booleano per verificare se si sta draggando
		private boolean drag;
		//numero di guida (quadrado) che si sta attualmente spostando
		private int rect;
		//colore attualmente selezionato
		private Color colorC;
		//stile che la forma dovrà prendere
		private int stile;
		//punto per facilitare il disegno della penna
		private Point2D test;
		//booleano per verificare se si deve scegliere un colore random
		private boolean random;
		//booleano per verificare se attivare l'antialias
		private boolean qualityB;
		//BufferedImage necessaria per il salvataggio di un file
		private BufferedImage img;
		//usato per risolvere un piccolo problema per il caricamento di un immagine
		private int first = 20;
		//variabile usata per gestire meglio il ctrl-z
		private long time;

		public Paint() {
			isSaved = true;
			NStrumento = 4;
			colorC = Color.black;
			stile = 0;
			random = false;
			qualityB = true;
			//setto lo sfondo 
			this.setBackground(Color.WHITE);
			//setto i metodi per attivare la tastiera
			this.requestFocusInWindow();
			this.requestFocus();
			this.setFocusable(true);

		}

		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			//casto la graifica
			Graphics2D g2=(Graphics2D)g;
			//traduco le cordinate per avitare di contare lo spazio delle barri dei menu
			g2.translate(-135,-66);

			ShapeP s=null;
			//verifico se c'è un'immagine da caricare
			if(img != null) {
				//disegno l'immagine
				g2.drawImage(img,135,66,this.getWidth(),this.getHeight(),null);
				//piccolo trucchetto usato per risolvere caricamenti incompleti
				if(first>0) {
					repaint();
					first--;
				}
			}
			//inizio a scorrermi la lista dove sono presenti tutte le figure da disegnare
			for(int i=0;i<shapes.size();i++) {
				s=shapes.get(i);
				int j=0;
				//disegno i quadratini usati per draggare le figure geometriche
				while(s.isDraglable() && s.isSelect() && j<s.getPoints().length ) {

					Point2D p=(Point2D) s.getPoints()[j];
					//disegno il quadrato con bordo bianco in modo che sia facilmente riconoscibile
					g2.setColor(Color.black);
					g2.fill(createRect(p));
					g2.setColor(Color.white);
					g2.draw(createRect(p));
					j++;
				}
				//attiva l'antialias
				if(qualityB)
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				s.draw(g2);

			}
			//metodi per migliorare le prestazioni
			g2.dispose();
			g2.finalize();


		}
		//update serve per ascoltare gli eventi che vengono mandati dagli ascoltatori
		@Override //recupero il mandante e in base a questo devio la chiamata al metodo predefinito
		public void update(Observable arg0, Object arg1) {
			if(arg0 instanceof MouseListener1)
				listenerMouse((MouseEvent) arg1);
			if(arg0 instanceof MouseMotionListener1)
				listenerMouseMotion((MouseEvent) arg1);
			if(arg0 instanceof KeyListener1)
				listenerKey((KeyEvent) arg1);
			if(arg0 instanceof ActionListener1)
				listenerMenu((ActionEvent) arg1);


		}
		//gestore del menu e dei varii bottoni
		private void listenerMenu(ActionEvent e)  {

			Object source = e.getSource();
			ShapeP s=null;

			if (source == jButton1) s=creator.getShape(1);
			else if (source == newPaint) newPaint();
			else if (source == savePaint) savePaint();
			else if (source == openPaint) openPaint();
			else if (source == printPaint) printPaint();
			else if (source == setOption) setSquare();
			else if (source == about) aboutDialog();
			else if (source == exit) exit();
			else if (source == jButton2) s=creator.getShape(2);
			else if (source == jButton3) s=creator.getShape(3);
			else if (source == jButton4) s=creator.getShape(8);
			else if (source == color) colorSelection();
			else if (source == circle) NStrumento = 4;
			else if (source == pen) NStrumento = 7; 
			else if (source == square) NStrumento = 5;
			else if (source == star) NStrumento = 6;
			else if (source == full) stile=0;
			else if (source == empty) stile=1; 
			else if (source == both) stile=2;
			else if (source == eraser) NStrumento = 9;
			else if (source == randomColor) {
				boolean b=randomColor.isSelected();
				color.setEnabled(!b);
				colorC=b?null:color.getForeground();
				if(random) {
					random = false;
					colorC = Color.black;
				}
				else
					random = true;
			} else if(source==quality) {
				if(!qualityB)
					qualityB=true;
				else 
					qualityB=false;
			}
			waitArea = s;




		}
		@SuppressWarnings("static-access")//metodo per gestire gli eventi del mouse
		private void listenerMouse(MouseEvent e) {
			if(e.getID() == e.MOUSE_CLICKED) {
				if(waitArea != null) {
					setUpShape(waitArea, e.getPoint());
					selectedShape = waitArea;
					waitArea = null;
				}
				else
					checkClick(e.getPoint());
			}
			else {
				drag = false;
				test = null;
			}


		}
		//altro metodo per gestire eventi del mouse
		private void listenerMouseMotion(MouseEvent e) {

			if(!drag)
				checkClickForDrag(e.getPoint());
			if(drag) {
				selectedShape.setPoints(e.getPoint(),rect);
				repaint();
			}
			else {

				setUpShape(creator.getShape(NStrumento), e.getPoint());

			}

		}
		//metodo per modificare la dimensione delle guide
		private void setSquare() {
			boolean ok=false;
			while (!ok) //Itero finche' non ottengo delle dimensioni del disegno accettabili
			{
				//Recupero del dimensioni
				String str=JOptionPane.showInputDialog(this,"Inserire le nuove dimensioni\n(minimo 10, massimo 80)",new Integer(15));
				if (str!=null)
					try
				{
						int dim=Integer.parseInt(str);
						ok=dim>=10&&dim<=80;

						if (ok) sizeS = dim;
				}
				catch (Exception e) {}
			}
		}

		private void aboutDialog() {
			JOptionPane.showMessageDialog(null, "MiniPainter \nRealizzato da Gabriele Gelardi & Natalia Germana La Rocca\n Per info contattare gigante.gabriele@hotmail.it", "Info MiniPainter v 1.0", 1, null);
		}
		//metodo per selezionare il colore
		private void colorSelection()
		{
			//Visualizzo la finestra di scelta del colore
			Color c=JColorChooser.showDialog(this,"Selezione Colore",color.getBackground());
			if (c!=null) //Se ho selezionato un colore
			{
				//Imposto il colore di background del bottone
				color.setBackground(c);
				//Recupero le componenti RGB del colore
				int col=c.getRGB();
				int r=(col&0x00FF0000)>>16;
						int g=(col&0x0000FF00)>>8;
						int b=col&0x000000FF;
						//Ne trovo il negativo
						r=255-r;
						g=255-g;
						b=255-b;
						//Imposto il negativo come colore di foreground del bottone
						color.setForeground(new Color(r,g,b));
						//Conservo il colore
						colorC=c;
			}
		}
		private void exit() {
			checkSaved();
			System.exit(0);
		}
		public void checkSaved() {
			if (!isSaved&&
					JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(this,"Il disegno non e' stato salvato.\nVuoi salvarlo?","Salvataggio",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE))
				this.savePaint();
		}
		@SuppressWarnings("static-access")
		private void savePaint() {
			int option2=JOptionPane.NO_OPTION;
			File f=null;
			String ext="JPEG";
			String str = null;
			while (option2==JOptionPane.NO_OPTION) //Finche' non decido di salvare
			{
				//Visualizzo la finestra di dialogo
				int option=chooser.showSaveDialog(this);
				if (option==chooser.APPROVE_OPTION) //Se ho premuto il tasto salva
				{
					try
					{
						//Recupero il file selezionato
						f=chooser.getSelectedFile();
						//Recupero il path del file
						str=f.getCanonicalPath();
						//Se il nome del file non contiene l'estensione, la aggiungo io a mano
						if (!str.toLowerCase().endsWith("."+ext)) str = str+"."+ext;
						//Se il file esiste chiedo se lo voglio sovrascrivere
						if (f.exists()) option2=JOptionPane.showConfirmDialog(this,"Il file esiste gia'.\nLo vuoi sovrascrivere?","Sovrascrittura",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						else option2=JOptionPane.YES_OPTION;
					}
					catch (Exception ex) {}
				}
				else option2=JOptionPane.CANCEL_OPTION;
			}
			if (option2==JOptionPane.YES_OPTION)
			{
				try {

					BufferedImage awtImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = awtImage.getGraphics();
					this.printAll(g);
					ImageIO.write(awtImage, "JPEG", new File(str));
				}
				catch (MalformedURLException e){ }
				catch (IOException e) {}

			}
		}
		private void printPaint() {

			try {

				//Ottengo un PrinterJob
				PrinterJob job=PrinterJob.getPrinterJob();
				//Imposto l'oggetto da stampare
				job.setPrintable(new Print());
				//Visualizzo la finestra di stampa nativa
				boolean b=job.printDialog();
				//Stampo la pagina
				if (b) job.print();
			}
			catch (Exception ex) {JOptionPane.showMessageDialog(this,"Impossibile stampare","Errore",JOptionPane.ERROR_MESSAGE);}
		}

		@SuppressWarnings("static-access")
		private void openPaint() {
			this.checkSaved();

			//Visualizzo la finestra di dialogo
			int risposta=chooser.showOpenDialog(this);
			if (risposta==chooser.APPROVE_OPTION) {//Se ho premuto il tasto apri

				//Recupero il file selezionato
				File f=chooser.getSelectedFile();
				try {
					img = ImageIO.read(f);
					first = 20;
				} catch (IOException e) {}
			}
		}



		private void newPaint() {
			checkSaved();
			shapes = new ArrayList<ShapeP>();
			repaint();
			isSaved = true;

		}
		//metodo per gestire gli eventi della tastiera
		private void listenerKey(KeyEvent e) {
			if(e.getModifiers()==2) {
				System.out.println(e.getKeyCode());
				if(e.getKeyCode()==90) {
					removeShape();
					
				}
				else if(e.getKeyCode()==83)
					if((e.getWhen()-time)>150)
						removeShape();
				time = e.getWhen();
			}
			
		}
		//metodo per caricare una nuova fomra
		private void setUpShape(ShapeP shape, Point2D point) {
			//comportamento leggermente diverso per la penna
			if(shape instanceof Pen) {
				if(test == null) //verifico se il punto era già istanziato, altrimenti continuo con il punto precedente
					test = point;
				shape.setScale(size.getSelectedIndex()+5);
				shape.setStile(stile);
				shape.setFirstPoint(test);
				shape.setPoints(point, 1);
				test = point;
			}
			else {
				shape.setScale(size.getSelectedIndex()+5);
				shape.setStile(stile);
				shape.setFirstPoint(point);

			}//colore random
			if(random)
				shape.setColor(new Color((float)Math.random(),(float)Math.random(),(float) Math.random()));
			else
				shape.setColor(colorC);
			addShape(shape); //infine aggiungo la forma alla lista pronta per essere stampata

		}
		private void addShape(ShapeP s) {
			if(s!=null){
				shapes.add(s);
				checkOnlyOneSelect(s);
				isSaved = false;
				repaint();
			}
			//metodo per recuperare oggetti cancellati dalla gomma
			for(int i = 0; i<shapes.size()-1;i++) {
				if(shapes.get(i).getNShape() == 9) {
					for(int j = 0;j<shapes.size()-1;j++) {
						if(shapes.size()>i && shapes.size()>j )
							if(shapes.get(i) != shapes.get(j) && shapes.get(i).getShape().contains(createRect(shapes.get(j).getPoints()[0])))
								creator.releaseShape(shapes.remove(j));
					}
				}
			}
		}
		//metodo per rimuovere una figura
		private void removeShape() {
			if(shapes.size()!=0)
				creator.releaseShape(shapes.remove(shapes.size()-1));
			repaint();
		}
		//metodo pe disegnare le guide per le figure 
		private Rectangle2D createRect(Point2D p) {
			double x=p.getX()-sizeS/2;
			double y=p.getY()-sizeS/2;
			return new Rectangle2D.Double(x,y,sizeS,sizeS);

		}
		//verifica che ci sia una sola figura selezionata
		private void checkOnlyOneSelect(ShapeP p) {
			for(int i=0;i<shapes.size();i++)
				if(shapes.get(i)!=p && shapes.get(i).isSelect())
					shapes.get(i).select(false);
			if(p.isSelect())
				selectedShape = p;
			else 
				selectedShape = null;

		}
		//verifica se il punto selezionato in cui si sta draggando può essere draggato
		private void checkClickForDrag(Point2D p) {
			if(selectedShape!=null)
				for(int j=0; j<selectedShape.getPoints().length;j++)
					if(createRect(selectedShape.getPoints()[j]).contains(p)) {
						drag=true;
						rect=j;
					}
		}
		//verifica ce il click è fatto su figure selezionabili
		private void checkClick(Point2D p) {
			for(int i=0;i<shapes.size();i++) {
				if(shapes.get(i).getShape().contains(p) || shapes.get(i).getShape().getBounds().contains(p) ) {
					shapes.get(i).select(true);
					selectedShape=shapes.get(i);
					checkOnlyOneSelect(shapes.get(i));
					break;
				}
			}
			repaint();
		}
		//classe private per implementare la funziona di stampa
		private class Print implements Printable
		{
			//Per implementare Printable bisogna definire il metodo print
			public int print(Graphics g, PageFormat format, int page)
			{
				//Se ho gia' stampato la pagina comunico che non devo stampare altro
				if (page>=1) return Printable.NO_SUCH_PAGE;

				Graphics2D g2=(Graphics2D)g;
				//Mi sposto nell'area stampabile
				g2.translate(format.getImageableX(),format.getImageableY());
				//Disegno un rettangolo di contorno
				double w=format.getImageableWidth()-1;
				double h=format.getImageableHeight()-1;
				g2.draw(new Rectangle2D.Double(0,0,w,h));
				//Riproporziono la figura
				double scale=Math.max(paint.getWidth(),paint.getHeight())/Math.max(w,h);

				g2.scale(scale,scale);
				//Disegno (stampo) la figura
				paintComponent(g2);
				//Comunico che c'era ancora una pagina da stampare
				return Printable.PAGE_EXISTS;
			}
		}
	}

}
