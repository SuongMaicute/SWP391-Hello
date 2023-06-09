USE [master]
GO
/****** Object:  Database [BirdPlatform]    Script Date: 6/5/2023 9:57:23 PM ******/
CREATE DATABASE [BirdPlatform]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BirdPlatform', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\BirdPlatform.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BirdPlatform_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\BirdPlatform_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BirdPlatform] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BirdPlatform].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BirdPlatform] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BirdPlatform] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BirdPlatform] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BirdPlatform] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BirdPlatform] SET ARITHABORT OFF 
GO
ALTER DATABASE [BirdPlatform] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BirdPlatform] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BirdPlatform] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BirdPlatform] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BirdPlatform] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BirdPlatform] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BirdPlatform] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BirdPlatform] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BirdPlatform] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BirdPlatform] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BirdPlatform] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BirdPlatform] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BirdPlatform] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BirdPlatform] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BirdPlatform] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BirdPlatform] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BirdPlatform] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BirdPlatform] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BirdPlatform] SET  MULTI_USER 
GO
ALTER DATABASE [BirdPlatform] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BirdPlatform] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BirdPlatform] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BirdPlatform] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BirdPlatform] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BirdPlatform] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BirdPlatform] SET QUERY_STORE = OFF
GO
USE [BirdPlatform]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[feedbackID] [int] IDENTITY(1,1) NOT NULL,
	[img] [text] NULL,
	[star] [int] NOT NULL,
	[detail] [ntext] NULL,
	[productID] [int] NULL,
	[accID] [int] NOT NULL,
	[publishedDate] [datetime] NULL,
 CONSTRAINT [PK_Feedback] PRIMARY KEY CLUSTERED 
(
	[feedbackID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[ProductRate]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[ProductRate] ()
RETURNS TABLE
AS
RETURN
    select productID, sum(star)/count(productID) as star 
	from [Feedback] 
	group by productID
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[customerID] [int] IDENTITY(1,1) NOT NULL,
	[phoneNumber] [nchar](10) NOT NULL,
	[point] [nchar](10) NULL,
	[accountID] [int] NOT NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[customerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[accountID] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](34) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[role] [int] NOT NULL,
	[isDeleted] [bit] NOT NULL,
	[regisDate] [datetime] NULL,
	[avatar] [text] NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[accountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[orderID] [int] IDENTITY(1,1) NOT NULL,
	[orderDate] [datetime] NOT NULL,
	[total] [float] NOT NULL,
	[paymentID] [int] NULL,
	[customerID] [int] NOT NULL,
	[addressShipID] [int] NULL,
	[shipDate] [datetime] NULL,
	[status] [varchar](20) NOT NULL,
	[shopID] [int] NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[orderHistory]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[orderHistory] (
    @accountID INT
)
RETURNS TABLE
AS
RETURN
    select * from [Order] 
where customerID = (select customerID from [customer] left join [account] on [customer].accountID=@accountID)
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[orderDetailID] [int] IDENTITY(1,1) NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [float] NOT NULL,
	[productID] [int] NOT NULL,
	[orderID] [int] NOT NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[orderDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[orderHistoryQuantity]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[orderHistoryQuantity] ()
RETURNS TABLE
AS
RETURN
    select sum(quantity) as totalQuantity, orderID, quantity from [OrderDetail] group by orderID,quantity;
GO
/****** Object:  Table [dbo].[Product]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[productID] [int] IDENTITY(1,1) NOT NULL,
	[productName] [nvarchar](100) NOT NULL,
	[priceIn] [float] NOT NULL,
	[type] [char](3) NULL,
	[category] [char](3) NULL,
	[quantity] [int] NOT NULL,
	[description] [text] NULL,
	[status] [varchar](50) NOT NULL,
	[img] [text] NULL,
	[sku] [nvarchar](50) NULL,
	[shopID] [int] NULL,
	[priceOut] [float] NOT NULL,
	[pSale] [float] NULL,
	[dateIn] [datetime] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  UserDefinedFunction [dbo].[orderHistoryFirstProduct]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[orderHistoryFirstProduct] ()
RETURNS TABLE
AS
RETURN
    select top 1 orderID, [Product].productName as firstProductName from [OrderDetail] left join [Product] on [OrderDetail].productID=[Product].productID order by [Product].productID
GO
/****** Object:  Table [dbo].[Address]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Address](
	[addressID] [int] IDENTITY(1,1) NOT NULL,
	[detail] [nvarchar](50) NULL,
	[district] [nvarchar](50) NULL,
	[province] [nvarchar](50) NULL,
 CONSTRAINT [PK_Address] PRIMARY KEY CLUSTERED 
(
	[addressID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AddressShipment]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AddressShipment](
	[addressShipID] [int] IDENTITY(1,1) NOT NULL,
	[phoneShipment] [varchar](20) NOT NULL,
	[detail] [text] NULL,
	[district] [varchar](50) NOT NULL,
	[province] [varchar](50) NOT NULL,
	[customerID] [int] NOT NULL,
 CONSTRAINT [PK_AddressShipment] PRIMARY KEY CLUSTERED 
(
	[addressShipID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[categoryID] [char](3) NOT NULL,
	[categoryName] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Discount]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Discount](
	[discountID] [int] IDENTITY(1,1) NOT NULL,
	[img] [text] NOT NULL,
	[saleUp] [float] NOT NULL,
	[description] [text] NULL,
	[shopID] [int] NULL,
	[dateFrom] [datetime] NULL,
	[dateTo] [datetime] NULL,
 CONSTRAINT [PK_Discount] PRIMARY KEY CLUSTERED 
(
	[discountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[paymentID] [int] IDENTITY(1,1) NOT NULL,
	[paymentName] [varchar](50) NOT NULL,
	[payment_redirect] [bit] NOT NULL,
	[paymentImg] [text] NULL,
 CONSTRAINT [PK_Payment] PRIMARY KEY CLUSTERED 
(
	[paymentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ResetPass]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ResetPass](
	[gmail] [nvarchar](20) NOT NULL,
	[code] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_ResetPass] PRIMARY KEY CLUSTERED 
(
	[gmail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role] [int] IDENTITY(1,1) NOT NULL,
	[roleName] [varchar](10) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[role] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shop]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shop](
	[shopID] [int] IDENTITY(1,1) NOT NULL,
	[shopName] [nvarchar](34) NOT NULL,
	[avatar] [text] NULL,
	[rate] [float] NULL,
	[contact] [ntext] NOT NULL,
	[accountID] [int] NULL,
	[addressID] [int] NOT NULL,
	[view] [int] NULL,
 CONSTRAINT [PK_Shop] PRIMARY KEY CLUSTERED 
(
	[shopID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Type]    Script Date: 6/5/2023 9:57:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Type](
	[typeID] [char](3) NOT NULL,
	[typeName] [nchar](10) NULL,
 CONSTRAINT [PK_Type] PRIMARY KEY CLUSTERED 
(
	[typeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([accountID], [username], [email], [password], [role], [isDeleted], [regisDate], [avatar]) VALUES (2, N'bird', N's', N'1', 1, 0, CAST(N'2022-12-05T00:00:00.000' AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Address] ON 

INSERT [dbo].[Address] ([addressID], [detail], [district], [province]) VALUES (1, N'dgse', N'sts', N'stsd')
SET IDENTITY_INSERT [dbo].[Address] OFF
GO
INSERT [dbo].[Category] ([categoryID], [categoryName]) VALUES (N'bir', N'bird')
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([customerID], [phoneNumber], [point], [accountID]) VALUES (2, N'0990900909', NULL, 2)
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
SET IDENTITY_INSERT [dbo].[Order] ON 

INSERT [dbo].[Order] ([orderID], [orderDate], [total], [paymentID], [customerID], [addressShipID], [shipDate], [status], [shopID]) VALUES (3, CAST(N'2023-05-07T00:00:00.000' AS DateTime), 567, 1, 2, NULL, NULL, N'Pending', NULL)
INSERT [dbo].[Order] ([orderID], [orderDate], [total], [paymentID], [customerID], [addressShipID], [shipDate], [status], [shopID]) VALUES (4, CAST(N'2023-05-27T23:29:03.360' AS DateTime), 57890, 1, 2, NULL, NULL, N'Pending', NULL)
SET IDENTITY_INSERT [dbo].[Order] OFF
GO
SET IDENTITY_INSERT [dbo].[Payment] ON 

INSERT [dbo].[Payment] ([paymentID], [paymentName], [payment_redirect], [paymentImg]) VALUES (1, N'CODE', 0, NULL)
SET IDENTITY_INSERT [dbo].[Payment] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([productID], [productName], [priceIn], [type], [category], [quantity], [description], [status], [img], [sku], [shopID], [priceOut], [pSale], [dateIn]) VALUES (1, N'Bird', 500, N'bir', N'bir', 5, N'day la mot con bird', N'av', N'https://unsplash.com/fr/photos/vUNQaTtZeOo', N'', 1, 1000, 1, NULL)
INSERT [dbo].[Product] ([productID], [productName], [priceIn], [type], [category], [quantity], [description], [status], [img], [sku], [shopID], [priceOut], [pSale], [dateIn]) VALUES (2, N'Dog Bird', 566, N'bir', N'bir', 7, N'con cho chim', N'av', N'https://i.ibb.co/C9hkdD7/sofa.png', NULL, 1, 1000, 1, NULL)
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([role], [roleName]) VALUES (1, N'user')
INSERT [dbo].[Role] ([role], [roleName]) VALUES (2, N'admin')
INSERT [dbo].[Role] ([role], [roleName]) VALUES (3, N'sdmin')
SET IDENTITY_INSERT [dbo].[Role] OFF
GO
SET IDENTITY_INSERT [dbo].[Shop] ON 

INSERT [dbo].[Shop] ([shopID], [shopName], [avatar], [rate], [contact], [accountID], [addressID], [view]) VALUES (1, N'Shop1', NULL, 0.75, N'0999999999', 2, 1, NULL)
SET IDENTITY_INSERT [dbo].[Shop] OFF
GO
INSERT [dbo].[Type] ([typeID], [typeName]) VALUES (N'bir', N'bird      ')
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Role] FOREIGN KEY([role])
REFERENCES [dbo].[Role] ([role])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Role]
GO
ALTER TABLE [dbo].[AddressShipment]  WITH CHECK ADD  CONSTRAINT [FK_AddressShipment_Customer] FOREIGN KEY([customerID])
REFERENCES [dbo].[Customer] ([customerID])
GO
ALTER TABLE [dbo].[AddressShipment] CHECK CONSTRAINT [FK_AddressShipment_Customer]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([accountID])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Account]
GO
ALTER TABLE [dbo].[Discount]  WITH CHECK ADD  CONSTRAINT [FK_Discount_Shop] FOREIGN KEY([shopID])
REFERENCES [dbo].[Shop] ([shopID])
GO
ALTER TABLE [dbo].[Discount] CHECK CONSTRAINT [FK_Discount_Shop]
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Account] FOREIGN KEY([accID])
REFERENCES [dbo].[Account] ([accountID])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Account]
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([productID])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Product]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_AddressShipment] FOREIGN KEY([addressShipID])
REFERENCES [dbo].[AddressShipment] ([addressShipID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_AddressShipment]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Customer] FOREIGN KEY([customerID])
REFERENCES [dbo].[Customer] ([customerID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Customer]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Payment] FOREIGN KEY([paymentID])
REFERENCES [dbo].[Payment] ([paymentID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Payment]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Shop] FOREIGN KEY([shopID])
REFERENCES [dbo].[Shop] ([shopID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Shop]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([orderID])
REFERENCES [dbo].[Order] ([orderID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Product] FOREIGN KEY([productID])
REFERENCES [dbo].[Product] ([productID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Product]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([category])
REFERENCES [dbo].[Category] ([categoryID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Shop] FOREIGN KEY([shopID])
REFERENCES [dbo].[Shop] ([shopID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Shop]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Type] FOREIGN KEY([type])
REFERENCES [dbo].[Type] ([typeID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Type]
GO
ALTER TABLE [dbo].[Shop]  WITH CHECK ADD  CONSTRAINT [FK_Shop_Account] FOREIGN KEY([accountID])
REFERENCES [dbo].[Account] ([accountID])
GO
ALTER TABLE [dbo].[Shop] CHECK CONSTRAINT [FK_Shop_Account]
GO
ALTER TABLE [dbo].[Shop]  WITH CHECK ADD  CONSTRAINT [FK_Shop_Address] FOREIGN KEY([addressID])
REFERENCES [dbo].[Address] ([addressID])
GO
ALTER TABLE [dbo].[Shop] CHECK CONSTRAINT [FK_Shop_Address]
GO
USE [master]
GO
ALTER DATABASE [BirdPlatform] SET  READ_WRITE 
GO
