namespace WindowsFormsApp1
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.FirstName = new System.Windows.Forms.Label();
            this.LastName = new System.Windows.Forms.Label();
            this.fnametb = new System.Windows.Forms.TextBox();
            this.lnametb = new System.Windows.Forms.TextBox();
            this.Previous = new System.Windows.Forms.Button();
            this.Next = new System.Windows.Forms.Button();
            this.StreetNumber = new System.Windows.Forms.Label();
            this.Street = new System.Windows.Forms.Label();
            this.City = new System.Windows.Forms.Label();
            this.PostalCode = new System.Windows.Forms.Label();
            this.Province = new System.Windows.Forms.Label();
            this.Country = new System.Windows.Forms.Label();
            this.PhoneNumber = new System.Windows.Forms.Label();
            this.emailAddress = new System.Windows.Forms.Label();
            this.streettb = new System.Windows.Forms.TextBox();
            this.streetnotb = new System.Windows.Forms.TextBox();
            this.citytb = new System.Windows.Forms.TextBox();
            this.provincetb = new System.Windows.Forms.TextBox();
            this.countrytb = new System.Windows.Forms.TextBox();
            this.postalcodetb = new System.Windows.Forms.TextBox();
            this.phonetb = new System.Windows.Forms.TextBox();
            this.email_id_tb = new System.Windows.Forms.TextBox();
            this.ID = new System.Windows.Forms.Label();
            this.id_tb = new System.Windows.Forms.TextBox();
            this.Status = new System.Windows.Forms.Label();
            this.status_tb = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // FirstName
            // 
            this.FirstName.AutoSize = true;
            this.FirstName.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.FirstName.Location = new System.Drawing.Point(120, 69);
            this.FirstName.Name = "FirstName";
            this.FirstName.Size = new System.Drawing.Size(92, 20);
            this.FirstName.TabIndex = 0;
            this.FirstName.Text = "First Name";
            this.FirstName.Click += new System.EventHandler(this.label1_Click);
            // 
            // LastName
            // 
            this.LastName.AutoSize = true;
            this.LastName.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LastName.Location = new System.Drawing.Point(122, 122);
            this.LastName.Name = "LastName";
            this.LastName.Size = new System.Drawing.Size(91, 20);
            this.LastName.TabIndex = 1;
            this.LastName.Text = "Last Name";
            // 
            // fnametb
            // 
            this.fnametb.Location = new System.Drawing.Point(266, 69);
            this.fnametb.Name = "fnametb";
            this.fnametb.Size = new System.Drawing.Size(177, 22);
            this.fnametb.TabIndex = 2;
            this.fnametb.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // lnametb
            // 
            this.lnametb.Location = new System.Drawing.Point(266, 120);
            this.lnametb.Name = "lnametb";
            this.lnametb.Size = new System.Drawing.Size(177, 22);
            this.lnametb.TabIndex = 3;
            this.lnametb.TextChanged += new System.EventHandler(this.lnametb_TextChanged);
            // 
            // Previous
            // 
            this.Previous.Location = new System.Drawing.Point(642, 225);
            this.Previous.Name = "Previous";
            this.Previous.Size = new System.Drawing.Size(113, 37);
            this.Previous.TabIndex = 4;
            this.Previous.Text = "Previous  <<";
            this.Previous.UseVisualStyleBackColor = true;
            this.Previous.Click += new System.EventHandler(this.Previous_Click);
            // 
            // Next
            // 
            this.Next.Location = new System.Drawing.Point(862, 225);
            this.Next.Name = "Next";
            this.Next.Size = new System.Drawing.Size(112, 37);
            this.Next.TabIndex = 5;
            this.Next.Text = "Next >>";
            this.Next.UseVisualStyleBackColor = true;
            this.Next.Click += new System.EventHandler(this.Next_Click);
            // 
            // StreetNumber
            // 
            this.StreetNumber.AutoSize = true;
            this.StreetNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.StreetNumber.Location = new System.Drawing.Point(122, 211);
            this.StreetNumber.Name = "StreetNumber";
            this.StreetNumber.Size = new System.Drawing.Size(118, 20);
            this.StreetNumber.TabIndex = 6;
            this.StreetNumber.Text = "Street Number";
            this.StreetNumber.Click += new System.EventHandler(this.label1_Click_1);
            // 
            // Street
            // 
            this.Street.AutoSize = true;
            this.Street.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.Street.Location = new System.Drawing.Point(122, 168);
            this.Street.Name = "Street";
            this.Street.Size = new System.Drawing.Size(54, 20);
            this.Street.TabIndex = 7;
            this.Street.Text = "Street";
            // 
            // City
            // 
            this.City.AutoSize = true;
            this.City.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.City.Location = new System.Drawing.Point(122, 259);
            this.City.Name = "City";
            this.City.Size = new System.Drawing.Size(38, 20);
            this.City.TabIndex = 8;
            this.City.Text = "City";
            this.City.Click += new System.EventHandler(this.label3_Click);
            // 
            // PostalCode
            // 
            this.PostalCode.AutoSize = true;
            this.PostalCode.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.PostalCode.Location = new System.Drawing.Point(122, 400);
            this.PostalCode.Name = "PostalCode";
            this.PostalCode.Size = new System.Drawing.Size(100, 20);
            this.PostalCode.TabIndex = 9;
            this.PostalCode.Text = "Postal Code";
            // 
            // Province
            // 
            this.Province.AutoSize = true;
            this.Province.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.Province.Location = new System.Drawing.Point(122, 302);
            this.Province.Name = "Province";
            this.Province.Size = new System.Drawing.Size(74, 20);
            this.Province.TabIndex = 10;
            this.Province.Text = "Province";
            // 
            // Country
            // 
            this.Country.AutoSize = true;
            this.Country.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.Country.Location = new System.Drawing.Point(122, 354);
            this.Country.Name = "Country";
            this.Country.Size = new System.Drawing.Size(67, 20);
            this.Country.TabIndex = 11;
            this.Country.Text = "Country";
            // 
            // PhoneNumber
            // 
            this.PhoneNumber.AutoSize = true;
            this.PhoneNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.PhoneNumber.Location = new System.Drawing.Point(122, 442);
            this.PhoneNumber.Name = "PhoneNumber";
            this.PhoneNumber.Size = new System.Drawing.Size(120, 20);
            this.PhoneNumber.TabIndex = 12;
            this.PhoneNumber.Text = "Phone Number";
            // 
            // emailAddress
            // 
            this.emailAddress.AutoSize = true;
            this.emailAddress.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.emailAddress.Location = new System.Drawing.Point(120, 480);
            this.emailAddress.Name = "emailAddress";
            this.emailAddress.Size = new System.Drawing.Size(116, 20);
            this.emailAddress.TabIndex = 13;
            this.emailAddress.Text = "email Address";
            // 
            // streettb
            // 
            this.streettb.Location = new System.Drawing.Point(266, 166);
            this.streettb.Name = "streettb";
            this.streettb.Size = new System.Drawing.Size(177, 22);
            this.streettb.TabIndex = 14;
            this.streettb.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // streetnotb
            // 
            this.streetnotb.Location = new System.Drawing.Point(266, 211);
            this.streetnotb.Name = "streetnotb";
            this.streetnotb.Size = new System.Drawing.Size(177, 22);
            this.streetnotb.TabIndex = 15;
            // 
            // citytb
            // 
            this.citytb.Location = new System.Drawing.Point(266, 257);
            this.citytb.Name = "citytb";
            this.citytb.Size = new System.Drawing.Size(177, 22);
            this.citytb.TabIndex = 16;
            // 
            // provincetb
            // 
            this.provincetb.Location = new System.Drawing.Point(266, 302);
            this.provincetb.Name = "provincetb";
            this.provincetb.Size = new System.Drawing.Size(177, 22);
            this.provincetb.TabIndex = 17;
            this.provincetb.TextChanged += new System.EventHandler(this.textBox6_TextChanged);
            // 
            // countrytb
            // 
            this.countrytb.Location = new System.Drawing.Point(266, 352);
            this.countrytb.Name = "countrytb";
            this.countrytb.Size = new System.Drawing.Size(177, 22);
            this.countrytb.TabIndex = 18;
            this.countrytb.TextChanged += new System.EventHandler(this.countrytb_TextChanged);
            // 
            // postalcodetb
            // 
            this.postalcodetb.Location = new System.Drawing.Point(266, 398);
            this.postalcodetb.Name = "postalcodetb";
            this.postalcodetb.Size = new System.Drawing.Size(177, 22);
            this.postalcodetb.TabIndex = 19;
            // 
            // phonetb
            // 
            this.phonetb.Location = new System.Drawing.Point(266, 442);
            this.phonetb.Name = "phonetb";
            this.phonetb.Size = new System.Drawing.Size(177, 22);
            this.phonetb.TabIndex = 20;
            // 
            // email_id_tb
            // 
            this.email_id_tb.Location = new System.Drawing.Point(266, 478);
            this.email_id_tb.Name = "email_id_tb";
            this.email_id_tb.Size = new System.Drawing.Size(177, 22);
            this.email_id_tb.TabIndex = 21;
            // 
            // ID
            // 
            this.ID.AutoSize = true;
            this.ID.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.ID.Location = new System.Drawing.Point(120, 29);
            this.ID.Name = "ID";
            this.ID.Size = new System.Drawing.Size(26, 20);
            this.ID.TabIndex = 22;
            this.ID.Text = "ID";
            // 
            // id_tb
            // 
            this.id_tb.Location = new System.Drawing.Point(266, 27);
            this.id_tb.Name = "id_tb";
            this.id_tb.Size = new System.Drawing.Size(177, 22);
            this.id_tb.TabIndex = 23;
            // 
            // Status
            // 
            this.Status.AutoSize = true;
            this.Status.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F);
            this.Status.Location = new System.Drawing.Point(579, 29);
            this.Status.Name = "Status";
            this.Status.Size = new System.Drawing.Size(57, 20);
            this.Status.TabIndex = 24;
            this.Status.Text = "Status";
            this.Status.Click += new System.EventHandler(this.label1_Click_2);
            // 
            // status_tb
            // 
            this.status_tb.Location = new System.Drawing.Point(663, 29);
            this.status_tb.Name = "status_tb";
            this.status_tb.Size = new System.Drawing.Size(345, 22);
            this.status_tb.TabIndex = 25;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1048, 539);
            this.Controls.Add(this.status_tb);
            this.Controls.Add(this.Status);
            this.Controls.Add(this.id_tb);
            this.Controls.Add(this.ID);
            this.Controls.Add(this.email_id_tb);
            this.Controls.Add(this.phonetb);
            this.Controls.Add(this.postalcodetb);
            this.Controls.Add(this.countrytb);
            this.Controls.Add(this.provincetb);
            this.Controls.Add(this.citytb);
            this.Controls.Add(this.streetnotb);
            this.Controls.Add(this.streettb);
            this.Controls.Add(this.emailAddress);
            this.Controls.Add(this.PhoneNumber);
            this.Controls.Add(this.Country);
            this.Controls.Add(this.Province);
            this.Controls.Add(this.PostalCode);
            this.Controls.Add(this.City);
            this.Controls.Add(this.Street);
            this.Controls.Add(this.StreetNumber);
            this.Controls.Add(this.Next);
            this.Controls.Add(this.Previous);
            this.Controls.Add(this.lnametb);
            this.Controls.Add(this.fnametb);
            this.Controls.Add(this.LastName);
            this.Controls.Add(this.FirstName);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label FirstName;
        private System.Windows.Forms.Label LastName;
        private System.Windows.Forms.TextBox fnametb;
        private System.Windows.Forms.TextBox lnametb;
        private System.Windows.Forms.Button Previous;
        private System.Windows.Forms.Button Next;
        private System.Windows.Forms.Label StreetNumber;
        private System.Windows.Forms.Label Street;
        private System.Windows.Forms.Label City;
        private System.Windows.Forms.Label PostalCode;
        private System.Windows.Forms.Label Province;
        private System.Windows.Forms.Label Country;
        private System.Windows.Forms.Label PhoneNumber;
        private System.Windows.Forms.Label emailAddress;
        private System.Windows.Forms.TextBox streettb;
        private System.Windows.Forms.TextBox streetnotb;
        private System.Windows.Forms.TextBox citytb;
        private System.Windows.Forms.TextBox provincetb;
        private System.Windows.Forms.TextBox countrytb;
        private System.Windows.Forms.TextBox postalcodetb;
        private System.Windows.Forms.TextBox phonetb;
        private System.Windows.Forms.TextBox email_id_tb;
        private System.Windows.Forms.Label ID;
        private System.Windows.Forms.TextBox id_tb;
        private System.Windows.Forms.Label Status;
        private System.Windows.Forms.TextBox status_tb;
    }
}

