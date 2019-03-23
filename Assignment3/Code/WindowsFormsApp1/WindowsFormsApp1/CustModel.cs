namespace WindowsFormsApp1
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class CustModel : DbContext
    {
        public CustModel()
            : base("name=Model2")
        {
        }

        public virtual DbSet<Cust> Custs { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Cust>()
                .Property(e => e.FirstName)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.LastName)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.StreetNumber)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.Street)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.City)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.Province)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.Country)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.PostalCode)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.PhoneNumber)
                .IsUnicode(false);

            modelBuilder.Entity<Cust>()
                .Property(e => e.Email_ID)
                .IsUnicode(false);
        }
    }
}
