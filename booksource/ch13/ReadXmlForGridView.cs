using System;
using System.Data;
using System.Windows.Forms;

namespace booksource.ch13
{
  public partial class ReadXmlForGridView : Form
  {
    public ReadXmlForGridView()
    {
      InitializeComponent();
    }

    private void ReadXmlForGridView_Load(object sender, EventArgs e)
    {
      DataSet dataSet = new DataSet();
      dataSet.ReadXml(@"..\..\ch13\booklist.xml");

      BindingSource bindingSource = new BindingSource();
      bindingSource.DataSource = dataSet.Tables[0];
      dataGridView1.DataSource = bindingSource;
    }

    [STAThread]
    static void Main()
    {
      Application.Run(new ReadXmlForGridView());
    }
  }
}