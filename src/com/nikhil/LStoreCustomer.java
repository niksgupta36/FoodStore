package com.nikhil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64;

@MultipartConfig
@WebServlet("/LStoreCustomer")
public class LStoreCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LStoreCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 CustomerDAOImpl cust = new CustomerDAOImpl();
	     	Part filePart = request.getPart("file");
			String submitType = request.getParameter("submit");
		//	String fileName = getFileName(filePart);
			
			OutputStream out = null;
		    InputStream filecontent = null;
		    final PrintWriter writer = response.getWriter();
		    File file = File.createTempFile("personFace", ".jpg");
		    try {
		    //	File file = File.createTempFile("personFace", ".jpg");
		        out = new FileOutputStream(file);
		        filecontent = filePart.getInputStream();
		        
		        int read = 0;
		        final byte[] bytes = new byte[1024];
		        
		        while ((read = filecontent.read(bytes)) != -1) {
		            out.write(bytes, 0, read);
		        }
		        FaceDetect detect = new FaceDetect();
				//File file1 = new File("C:/Users/HP/Desktop/"+fileName);
				   // File file1 = File.createTempFile("personFace", ".jpg");
					System.out.println(file);
					String faceid = detect.getFaceId(file);
					System.out.println(faceid);
					
					
					try {
						
						//System.out.println(file);
						FileOutputStream output = new FileOutputStream(file);
						
						String[] nameandnumber = cust.getName(faceid);
						String custname = nameandnumber[0];
						String custnumber = nameandnumber[1];
						System.out.println(custname);
						
						OrderDAOImpl order = new OrderDAOImpl();
						
						int getorder1 = order.getOrder(custnumber);
						
						order.changestatus(getorder1);
						
						response.setContentType("text/plain");
				     //   PrintWriter out1 = response.getWriter();
				        String a = "Welcome "+custname+"!";
				        String b = "Your photo has been taken successfully.";
				        String c = "Your orderId is : " + getorder1;
				        String d = "But No Order found! Please click your photo and try again.";
				        
						if(getorder1!=0) 
							{
							System.out.println("Your order is : "+getorder1);
							request.setAttribute("a", a);
							request.setAttribute("b", b);
							request.setAttribute("c", c);
							}
						else	
							{
							System.out.println("Please try again!");
							request.setAttribute("a", a);
							request.setAttribute("b", b);
							request.setAttribute("c", d);
							}
						
						
						request.getServletContext().getRequestDispatcher("/NewFile.jsp").forward(request, response);
						
						output.flush();
						output.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
		       // request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		      //  writer.println("New file " + fileName + " created at " + path);
		    } catch (FileNotFoundException fne) {
		        writer.println("You either did not specify a file to upload or are "
		                + "trying to upload a file to a protected or nonexistent "
		                + "location.");
		        writer.println("<br/> ERROR: " + fne.getMessage());
		        
		    } finally {
		        if (out != null) {
		            out.close();
		        }
		        if (filecontent != null) {
		            filecontent.close();
		        }
		        if (writer != null) {
		            writer.close();
		        }
		    }
		    
		  
		
		
	
		
	}
		
		
	}


