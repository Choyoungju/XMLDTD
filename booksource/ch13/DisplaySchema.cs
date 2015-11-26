using System;
using System.Data;

namespace booksource.ch13
{
	public class DisplaySchema
	{
		public static void displayDataSetSchema(DataSet dataSet) 
		{
      Console.WriteLine("######################################################");
      Console.WriteLine("##  DataSet 의 구조");
      Console.WriteLine("######################################################\n");
			foreach(DataTable dataTable in dataSet.Tables)
			{
				displayDataTableSchema(dataTable);
			}
		}

		public static void displayDataTableSchema(DataTable dataTable) 
		{
      Console.WriteLine("**********************************************");
      Console.WriteLine("테이블명: " + dataTable.TableName);
      Console.WriteLine("**********************************************");
			displayConstraint(dataTable);
			displayDataColumn(dataTable);
		}

		public static void displayConstraint(DataTable dataTable)
		{
			Console.WriteLine("[제약 조건]");
			
			DataColumn[] pkDataColumns = dataTable.PrimaryKey;
			foreach(DataColumn dataColumn in pkDataColumns)
			{
				Console.WriteLine("Prymary Key");
				Console.WriteLine("\t" + dataColumn.ColumnName);
			}

			ConstraintCollection constraintCollection = dataTable.Constraints;
			foreach(Constraint constraint in constraintCollection)
			{
				Console.WriteLine(constraint.GetType());

				if(constraint is UniqueConstraint)
				{
					UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
					DataColumn[] dataColumns = uniqueConstraint.Columns;
					foreach(DataColumn dataColumn in dataColumns)
					{
						Console.WriteLine("\t" + uniqueConstraint.ConstraintName + ":\t" + dataColumn.ColumnName);	
					}
				} 
				else if(constraint is ForeignKeyConstraint)
				{
					ForeignKeyConstraint foreignKeyConstraint = (ForeignKeyConstraint) constraint;
					DataColumn[] dataColumns = foreignKeyConstraint.Columns;
					foreach(DataColumn dataColumn in dataColumns)
					{
						Console.WriteLine("\t" + foreignKeyConstraint.ConstraintName + ":\t" + dataColumn.ColumnName);	
					}
				}
			}
		}

		public static void displayDataColumn(DataTable dataTable)
		{
      Console.WriteLine("----------------------------------------");
      Console.WriteLine("[컬럼명] \t[컬럼속성]");
      Console.WriteLine("----------------------------------------");
			DataColumnCollection dataColumnCollection = dataTable.Columns;
			foreach(DataColumn dataColumn in dataColumnCollection)
			{
				Console.WriteLine(dataColumn.ColumnName);
        Console.WriteLine("\t\t" + "DataType: " + dataColumn.DataType);
        Console.WriteLine("\t\t" + "MaxLength: " + dataColumn.MaxLength);
        Console.WriteLine("\t\t" + "AllowDBNull: " + dataColumn.AllowDBNull);
				if(dataColumn.AutoIncrement) 
				{
          Console.WriteLine("\t\t" + "AutoIncrement: " + dataColumn.AutoIncrement);
				}
			}
		}
	}
}
