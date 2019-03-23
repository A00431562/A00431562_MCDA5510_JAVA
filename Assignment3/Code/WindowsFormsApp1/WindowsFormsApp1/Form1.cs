using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form

    {
        static int point = 0;
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Next_Click(object sender, EventArgs e)
        {
            using (StreamWriter streamWriter = File.AppendText("LogFile_Form.txt"))
            {
                CustModel custModel = new CustModel();
                List<Cust> allCustomers = custModel.Custs.ToList();
                status_tb.Text = "";

                point = point + 1;


                if (point < allCustomers.Count)
                {
                    id_tb.Text = allCustomers[point].CustomerID.ToString();
                    fnametb.Text = allCustomers[point].FirstName;
                    lnametb.Text = allCustomers[point].LastName;
                    streettb.Text = allCustomers[point].Street;
                    streetnotb.Text = allCustomers[point].StreetNumber;
                    citytb.Text = allCustomers[point].City;
                    provincetb.Text = allCustomers[point].Province;
                    countrytb.Text = allCustomers[point].Country;
                    postalcodetb.Text = allCustomers[point].PostalCode;
                    phonetb.Text = allCustomers[point].PhoneNumber;
                    email_id_tb.Text = allCustomers[point].Email_ID;
                    Logger(streamWriter, "Next Clicked for : " + id_tb.Text);
                    formatvalid(postalcodetb.Text, phonetb.Text, email_id_tb.Text, streamWriter);
                }
                else
                {
                    status_tb.Text = "Last row reached in Customer Database";
                    point = allCustomers.Count - 1;
                    Logger(streamWriter, "On Clikcing Next: Last row reached in Customer Database for " + id_tb.Text);
                }
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            using (StreamWriter streamWriter = File.AppendText("LogFile_Form.txt"))
            { 
            CustModel custModel = new CustModel();
            List<Cust> allCustomers = custModel.Custs.ToList();
            Logger(streamWriter, "Form Loaded Successfully!");

            id_tb.Text = allCustomers[point].CustomerID.ToString();
            fnametb.Text = allCustomers[point].FirstName;
            lnametb.Text = allCustomers[point].LastName;
            streettb.Text = allCustomers[point].Street;
            streetnotb.Text = allCustomers[point].StreetNumber;
            citytb.Text = allCustomers[point].City;
            provincetb.Text = allCustomers[point].Province;
            countrytb.Text = allCustomers[point].Country;
            postalcodetb.Text = allCustomers[point].PostalCode;
            phonetb.Text = allCustomers[point].PhoneNumber;
            email_id_tb.Text = allCustomers[point].Email_ID;
            formatvalid(postalcodetb.Text, phonetb.Text, email_id_tb.Text, streamWriter);

            }
        }

        private void Logger(TextWriter twriter, String message)
        {
            twriter.WriteLine(message);
        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void textBox6_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void lnametb_TextChanged(object sender, EventArgs e)
        {

        }

        private void countrytb_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click_2(object sender, EventArgs e)
        {

        }

        private void Previous_Click(object sender, EventArgs e)
        {
            using (StreamWriter streamWriter = File.AppendText("LogFile_Form.txt"))
            { 
            CustModel custModel = new CustModel();
            List<Cust> allCustomers = custModel.Custs.ToList();

            status_tb.Text = "";
            point = point - 1;

            if (point>=0)
            {
                id_tb.Text = allCustomers[point].CustomerID.ToString();
                fnametb.Text = allCustomers[point].FirstName;
                lnametb.Text = allCustomers[point].LastName;
                streettb.Text = allCustomers[point].Street;
                streetnotb.Text = allCustomers[point].StreetNumber;
                citytb.Text = allCustomers[point].City;
                provincetb.Text = allCustomers[point].Province;
                countrytb.Text = allCustomers[point].Country;
                postalcodetb.Text = allCustomers[point].PostalCode;
                phonetb.Text = allCustomers[point].PhoneNumber;
                email_id_tb.Text = allCustomers[point].Email_ID;
                Logger(streamWriter, "Previous Clicked for : " + id_tb.Text);
                formatvalid(postalcodetb.Text, phonetb.Text, email_id_tb.Text, streamWriter);
            }
            else
            {
                status_tb.Text = "First row reached in Customer Database";
                point = 0;
                Logger(streamWriter, "On Clicking Previous: First row reached in Customer Database for "+id_tb.Text);
            }
            }
        }




        private void formatvalid(string postcode, string phone, string email, StreamWriter streamWriter)
        {
            
                var valid_postcode = Regex.Match(postcode, @"^([a-zA-Z]\d[a-zA-Z]( )?\d[a-zA-Z]\d)$");

                if (!valid_postcode.Success)
                {
                    status_tb.Text = "Incorrect postal code format!";
                    Logger(streamWriter, "Incorrect postal code format!");
                }

                var valid_phone = Regex.Match(phone, @"^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$");

                if (!valid_phone.Success)
                {
                    status_tb.Text = "Phone Number format not acceptable!";
                    Logger(streamWriter, "Phone Number format not acceptable!");

                }

                var valid_email = Regex.Match(email, @"\A(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)\Z", RegexOptions.IgnoreCase);

                if (!valid_email.Success)
                {
                    status_tb.Text = "Email Address format not acceptable!";
                    Logger(streamWriter, "Email Address format not acceptable!");
                }
            
        }
    }
}
