package com.indiavyapar.webservice.constants;

public enum BusinessCategory {

	 RESTAURANT_CATERING_FASTFOOD("Restaurant, Catering & Fast Food"),
	    SALON_SPA_BEAUTY("Salon, Spa & Beauty"),
	    FITNESS_GYM_YOGA("Gym, Yoga & Fitness"),
	    CLOTHING_BOUTIQUE("Clothing / Boutique"),
	    GROCERY_GENERAL_STORE("Grocery & General Store"),
	    MEDICAL_CLINIC_PHARMACY("Clinic / Pharmacy / Health"),
	    EDUCATION_TUTORING("Education & Coaching"),
	    ELECTRICAL_PLUMBING_REPAIR("Electrician / Plumber / Repairs"),
	    DIGITAL_MARKETING_AGENCY("Digital Marketing / Agency"),
	    PHOTOGRAPHY_MEDIA("Photography & Media"),
	    EVENT_MANAGEMENT_DECOR("Event Planner & Decor"),
	    PET_CARE_GROOMING("Pet Care / Grooming"),
	    TRAVEL_TICKETING("Travel Agent / Ticket Booking"),
	    REAL_ESTATE_CONSTRUCTION("Real Estate & Construction"),
	    LEGAL_ACCOUNTING("Lawyer / CA / Financial Services"),
	    HANDMADE_CRAFTS("Handmade & Crafts"),
	    AUTOMOBILE_REPAIR("Automobile Repair / Garage"),
	    ECOMMERCE_RESELLING("Online Store / Reselling"),
	    HOME_BAKING_CATERING("Home Baking & Catering"),
	    NGO_COMMUNITY("NGO / Community Work"),
	    FREELANCER_CONSULTANT("Freelancer / Consultant"),
	    PRINTING_DESIGN("Printing & Design"),
	    INTERIOR_FURNITURE("Interior & Furniture Design");

	    private final String displayName;

	    BusinessCategory(String displayName) {
	        this.displayName = displayName;
	    }

	    public String getDisplayName() {
	        return displayName;
	    }
}
