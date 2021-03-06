﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.18052
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace frontier_client.ServiceReference1 {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://localhost/RestaurantWebService", ConfigurationName="ServiceReference1.RestaurantWebService")]
    public interface RestaurantWebService {
        
        // CODEGEN: Parameter 'order' requires additional schema information that cannot be captured using the parameter mode. The specific attribute is 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        frontier_client.ServiceReference1.placeOrderResponse placeOrder(frontier_client.ServiceReference1.placeOrder request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<frontier_client.ServiceReference1.placeOrderResponse> placeOrderAsync(frontier_client.ServiceReference1.placeOrder request);
        
        // CODEGEN: Parameter 'restaurants' requires additional schema information that cannot be captured using the parameter mode. The specific attribute is 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="restaurants")]
        frontier_client.ServiceReference1.getRestaurantsResponse getRestaurants(frontier_client.ServiceReference1.getRestaurants request);
        
        [System.ServiceModel.OperationContractAttribute(Action="", ReplyAction="*")]
        System.Threading.Tasks.Task<frontier_client.ServiceReference1.getRestaurantsResponse> getRestaurantsAsync(frontier_client.ServiceReference1.getRestaurants request);
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.18054")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://localhost/RestaurantWebService")]
    public partial class order : object, System.ComponentModel.INotifyPropertyChanged {
        
        private app[] appsField;
        
        private entree[] entreesField;
        
        private string restaurantNameField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("apps", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true, Order=0)]
        public app[] apps {
            get {
                return this.appsField;
            }
            set {
                this.appsField = value;
                this.RaisePropertyChanged("apps");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("entrees", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true, Order=1)]
        public entree[] entrees {
            get {
                return this.entreesField;
            }
            set {
                this.entreesField = value;
                this.RaisePropertyChanged("entrees");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public string restaurantName {
            get {
                return this.restaurantNameField;
            }
            set {
                this.restaurantNameField = value;
                this.RaisePropertyChanged("restaurantName");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.18054")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://localhost/RestaurantWebService")]
    public partial class app : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string nameField;
        
        private double priceField;
        
        private bool priceFieldSpecified;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string name {
            get {
                return this.nameField;
            }
            set {
                this.nameField = value;
                this.RaisePropertyChanged("name");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public double price {
            get {
                return this.priceField;
            }
            set {
                this.priceField = value;
                this.RaisePropertyChanged("price");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool priceSpecified {
            get {
                return this.priceFieldSpecified;
            }
            set {
                this.priceFieldSpecified = value;
                this.RaisePropertyChanged("priceSpecified");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.18054")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://localhost/RestaurantWebService")]
    public partial class menu : object, System.ComponentModel.INotifyPropertyChanged {
        
        private app[] availableAppsField;
        
        private entree[] availableEntreesField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("availableApps", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true, Order=0)]
        public app[] availableApps {
            get {
                return this.availableAppsField;
            }
            set {
                this.availableAppsField = value;
                this.RaisePropertyChanged("availableApps");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("availableEntrees", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true, Order=1)]
        public entree[] availableEntrees {
            get {
                return this.availableEntreesField;
            }
            set {
                this.availableEntreesField = value;
                this.RaisePropertyChanged("availableEntrees");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.18054")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://localhost/RestaurantWebService")]
    public partial class entree : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string nameField;
        
        private double priceField;
        
        private bool priceFieldSpecified;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string name {
            get {
                return this.nameField;
            }
            set {
                this.nameField = value;
                this.RaisePropertyChanged("name");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public double price {
            get {
                return this.priceField;
            }
            set {
                this.priceField = value;
                this.RaisePropertyChanged("price");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool priceSpecified {
            get {
                return this.priceFieldSpecified;
            }
            set {
                this.priceFieldSpecified = value;
                this.RaisePropertyChanged("priceSpecified");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.18054")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://localhost/RestaurantWebService")]
    public partial class restaurant : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string genreField;
        
        private menu menuField;
        
        private string nameField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string genre {
            get {
                return this.genreField;
            }
            set {
                this.genreField = value;
                this.RaisePropertyChanged("genre");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public menu menu {
            get {
                return this.menuField;
            }
            set {
                this.menuField = value;
                this.RaisePropertyChanged("menu");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public string name {
            get {
                return this.nameField;
            }
            set {
                this.nameField = value;
                this.RaisePropertyChanged("name");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="placeOrder", WrapperNamespace="http://localhost/RestaurantWebService", IsWrapped=true)]
    public partial class placeOrder {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://localhost/RestaurantWebService", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public frontier_client.ServiceReference1.order order;
        
        public placeOrder() {
        }
        
        public placeOrder(frontier_client.ServiceReference1.order order) {
            this.order = order;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="placeOrderResponse", WrapperNamespace="http://localhost/RestaurantWebService", IsWrapped=true)]
    public partial class placeOrderResponse {
        
        public placeOrderResponse() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getRestaurants", WrapperNamespace="http://localhost/RestaurantWebService", IsWrapped=true)]
    public partial class getRestaurants {
        
        public getRestaurants() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getRestaurantsResponse", WrapperNamespace="http://localhost/RestaurantWebService", IsWrapped=true)]
    public partial class getRestaurantsResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://localhost/RestaurantWebService", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("restaurants", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public frontier_client.ServiceReference1.restaurant[] restaurants;
        
        public getRestaurantsResponse() {
        }
        
        public getRestaurantsResponse(frontier_client.ServiceReference1.restaurant[] restaurants) {
            this.restaurants = restaurants;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface RestaurantWebServiceChannel : frontier_client.ServiceReference1.RestaurantWebService, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class RestaurantWebServiceClient : System.ServiceModel.ClientBase<frontier_client.ServiceReference1.RestaurantWebService>, frontier_client.ServiceReference1.RestaurantWebService {
        
        public RestaurantWebServiceClient() {
        }
        
        public RestaurantWebServiceClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public RestaurantWebServiceClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public RestaurantWebServiceClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public RestaurantWebServiceClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        frontier_client.ServiceReference1.placeOrderResponse frontier_client.ServiceReference1.RestaurantWebService.placeOrder(frontier_client.ServiceReference1.placeOrder request) {
            return base.Channel.placeOrder(request);
        }
        
        public void placeOrder(frontier_client.ServiceReference1.order order) {
            frontier_client.ServiceReference1.placeOrder inValue = new frontier_client.ServiceReference1.placeOrder();
            inValue.order = order;
            frontier_client.ServiceReference1.placeOrderResponse retVal = ((frontier_client.ServiceReference1.RestaurantWebService)(this)).placeOrder(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<frontier_client.ServiceReference1.placeOrderResponse> frontier_client.ServiceReference1.RestaurantWebService.placeOrderAsync(frontier_client.ServiceReference1.placeOrder request) {
            return base.Channel.placeOrderAsync(request);
        }
        
        public System.Threading.Tasks.Task<frontier_client.ServiceReference1.placeOrderResponse> placeOrderAsync(frontier_client.ServiceReference1.order order) {
            frontier_client.ServiceReference1.placeOrder inValue = new frontier_client.ServiceReference1.placeOrder();
            inValue.order = order;
            return ((frontier_client.ServiceReference1.RestaurantWebService)(this)).placeOrderAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        frontier_client.ServiceReference1.getRestaurantsResponse frontier_client.ServiceReference1.RestaurantWebService.getRestaurants(frontier_client.ServiceReference1.getRestaurants request) {
            return base.Channel.getRestaurants(request);
        }
        
        public frontier_client.ServiceReference1.restaurant[] getRestaurants() {
            frontier_client.ServiceReference1.getRestaurants inValue = new frontier_client.ServiceReference1.getRestaurants();
            frontier_client.ServiceReference1.getRestaurantsResponse retVal = ((frontier_client.ServiceReference1.RestaurantWebService)(this)).getRestaurants(inValue);
            return retVal.restaurants;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<frontier_client.ServiceReference1.getRestaurantsResponse> frontier_client.ServiceReference1.RestaurantWebService.getRestaurantsAsync(frontier_client.ServiceReference1.getRestaurants request) {
            return base.Channel.getRestaurantsAsync(request);
        }
        
        public System.Threading.Tasks.Task<frontier_client.ServiceReference1.getRestaurantsResponse> getRestaurantsAsync() {
            frontier_client.ServiceReference1.getRestaurants inValue = new frontier_client.ServiceReference1.getRestaurants();
            return ((frontier_client.ServiceReference1.RestaurantWebService)(this)).getRestaurantsAsync(inValue);
        }
    }
}
