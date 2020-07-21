package com.Advertisement.Advertisement.service;

import com.Advertisement.Advertisement.dtos.AdvertisementDTO;
import com.Advertisement.Advertisement.model.*;
import com.Advertisement.Advertisement.dtos.*;
import com.Advertisement.Advertisement.repository.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.netflix.client.http.HttpRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.servlet.http.HttpSession;

@Service
public class AdvertisementService {

	@Autowired
	AdvertisementRepository advertisementRepository;

	// @Autowired
	// UserRepository userRepository;

	@Autowired
	ReplyRepository replyRepository;

	@Autowired
	GradeService gradeService;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	CarClassRepository carClassRepository;

	@Autowired
	ModelRepository modelRepository;

	@Autowired
	FuelTypeRepository fuelTypeRepository;

	@Autowired
	TransmissionTypeRepository transmissionTypeRepository;

	@Autowired
	RestTemplate restTemplate;

	// @Autowired
	// EndUserRepository endUserRepository;

	// @Autowired
	// AgentRepository agentRepository;

	// @Autowired
	// LoggerService loggerService;

	// @Autowired
	// SessionService sessionService;

	public Advertisement save(AdvertisementCreationDTO advertisementCreationDTO, Long id) {

		System.out.println("/////////////Advertisement service//////////////////////////////////////");
		System.out.println(id);
		System.out.println("///////////////////////////////////////////////////");

		Model model = modelRepository.findByName(advertisementCreationDTO.getModel());
		Brand brand = brandRepository.findByName(advertisementCreationDTO.getBrand());
		CarClass carClass = carClassRepository.findByName(advertisementCreationDTO.getCarClass());
		FuelType fuelType = fuelTypeRepository.findByName(advertisementCreationDTO.getFuelType());
		TransmissionType transmissionType = transmissionTypeRepository
				.findByName(advertisementCreationDTO.getTransType());

		System.out.println("///////////////////////");
		System.out.println(advertisementCreationDTO.getTransType());
		System.out.println(transmissionType);
		System.out.println("////////////////////////");

		Advertisement ad = new Advertisement(advertisementCreationDTO.getName(), model, brand, fuelType,
				transmissionType, carClass, advertisementCreationDTO.getTravelled(),
				advertisementCreationDTO.getCarSeats(), advertisementCreationDTO.getPrice(), id,
				advertisementCreationDTO.getDiscount(), advertisementCreationDTO.getPictures(), 0.0);

		// kada se kreira korisnik kreira mu se i korpa u koju ce moci da dodaje oglase!

		return advertisementRepository.save(ad);
	}

	public void saveImage(MultipartFile image) {

		String path = System.getProperty("user.dir");

		// String path=
		// C:\\Users\\Sherlock\\Desktop\\Mikroservisi\\Frontend\\src\\assets\\images

	

		// dodajte putanju do vaseg dir
		String nazivSlike = image.getOriginalFilename().replace("/", "\\");
		
		byte[] bytes;
		try {
			bytes = image.getBytes();
			Path put = Paths.get("/etc", image.getOriginalFilename());
			Files.write(put, bytes);
			System.out.println("UPISAO");
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("UPAO U EXCEPTION");
		}
	}
	
	public List<CarDetailsDTO> getCarDetails() {
		List<Brand> brands = brandRepository.findAll();
		List<CarClass> classes = carClassRepository.findAll();
		List<Model> models = modelRepository.findAll();
		List<FuelType> fuels = fuelTypeRepository.findAll();
		List<TransmissionType> transmisions = transmissionTypeRepository.findAll();

		List<CarDetailsDTO> details = new ArrayList<CarDetailsDTO>();
		CarDetailsDTO temp;

		for (Brand brand : brands) {
			temp = new CarDetailsDTO(brand.getName(), brand.getCode(), "BRAND");

			details.add(temp);
		}

		for (Model model : models) {
			temp = new CarDetailsDTO(model.getName(), model.getCode(), "CARMODEL");

			details.add(temp);
		}

		for (CarClass carclass : classes) {
			temp = new CarDetailsDTO(carclass.getName(), carclass.getCode(), "CARCLASS");

			details.add(temp);
		}

		for (FuelType fuelType : fuels) {
			temp = new CarDetailsDTO(fuelType.getName(), fuelType.getCode(), "FUELTYPE");

			details.add(temp);
		}

		for (TransmissionType transmission : transmisions) {
			temp = new CarDetailsDTO(transmission.getName(), transmission.getCode(), "GEARSHIFT");

			details.add(temp);
		}

		return details;
	}

	public Boolean saveCarDetail(CarDetailsDTO carDetailsDTO) {
		if (carDetailsDTO.getType().toLowerCase().equals("brand")) {
			Brand newItem = new Brand();
			newItem.setCode(carDetailsDTO.getCode());
			newItem.setName(carDetailsDTO.getName());
			brandRepository.save(newItem);
		} else if (carDetailsDTO.getType().toLowerCase().equals("carmodel")) {
			Model newItem = new Model();
			newItem.setCode(carDetailsDTO.getCode());
			newItem.setName(carDetailsDTO.getName());
			modelRepository.save(newItem);
		} else if (carDetailsDTO.getType().toLowerCase().equals("carclass")) {
			CarClass newItem = new CarClass();
			newItem.setCode(carDetailsDTO.getCode());
			newItem.setName(carDetailsDTO.getName());
			carClassRepository.save(newItem);
		} else if (carDetailsDTO.getType().toLowerCase().equals("fuel")) {
			FuelType newItem = new FuelType();
			newItem.setCode(carDetailsDTO.getCode());
			newItem.setName(carDetailsDTO.getName());
			fuelTypeRepository.save(newItem);
		} else if (carDetailsDTO.getType().toLowerCase().equals("gearshift")) {
			TransmissionType newItem = new TransmissionType();
			newItem.setCode(carDetailsDTO.getCode());
			newItem.setName(carDetailsDTO.getName());
			transmissionTypeRepository.save(newItem);
		} else {
			return false;
		}

		return true;
	}

	public Boolean deleteCarDetail(CarDetailsDTO carDetailsDTO) {
		if (carDetailsDTO.getType().toLowerCase().equals("brand")) {
			brandRepository.deleteByCode(carDetailsDTO.getCode());
		} else if (carDetailsDTO.getType().toLowerCase().equals("carmodel")) {
			modelRepository.deleteByCode(carDetailsDTO.getCode());
		} else if (carDetailsDTO.getType().toLowerCase().equals("carclass")) {
			carClassRepository.deleteByCode(carDetailsDTO.getCode());
		} else if (carDetailsDTO.getType().toLowerCase().equals("fueltype")) {
			fuelTypeRepository.deleteByCode(carDetailsDTO.getCode());
		} else if (carDetailsDTO.getType().toLowerCase().equals("GEARSHIFT")) {
			transmissionTypeRepository.deleteByCode(carDetailsDTO.getCode());
		} else {
			return false;
		}

		return true;
	}

	public List<AdvertisementCreationDTO> findAll() {
		List<Advertisement> advertisements = advertisementRepository.findAll();

		List<AdvertisementCreationDTO> sending = new ArrayList<AdvertisementCreationDTO>();
		AdvertisementCreationDTO temp;
		for (int i = 0; i < advertisements.size(); i++) {
			advertisements.get(i).setGrade(gradeService.calculateGradeForAd(advertisements.get(i).getId()));
			Advertisement tempad = advertisements.get(i);

			temp = new AdvertisementCreationDTO(tempad.getId(), tempad.getName(), tempad.getModel().getName(),
					tempad.getBrand().getName(), tempad.getFuelType().getName(), tempad.getTransmissionType().getName(),
					tempad.getCarClass().getName(), tempad.getTravelled(), tempad.getCarSeats(), tempad.getPrice(),
					tempad.getPostedByID(), tempad.getDiscount(), tempad.getPriceWithDiscount(), tempad.getPictures(),
					tempad.getGrade());

			sending.add(temp);
		}

		// String name, String model, String brand, String fuelType, String transType,
		// String carClass, int travelled,
		// int carSeats, double price, double discount, double priceWithDiscount,
		// ArrayList<String> pictures, double grade

		// loggerService.doLog("neka funkcija", "neki rezultat", "WARNING"); //TIPOVI
		// LOGOVA : WARNING, ERROR, INFO
		// loggerService.doLog("neka funkcija", "neki rezultat", "ERROR"); //FUNKCIJE :
		// NAPRAVIO OGLAS, POSLAO ZAHTEV ZA OGLAS, ODOBRIO ZAHTEV, OTKAZAO ZAHTEV, ODBIO
		// ZAHTEV, OBRISAO OGLAS
		// loggerService.doLog("neka funkcija", "neki rezultat", "INFO"); //REZULTATI:
		// ID OGLASA/NEUSPESNO, ID ZAHTEVA/NEUSPESNO, ID ZAHTEVA/NEUSPESNO, ID
		// ZAHTEVA/NEUSPESNO, ID OGLASA/NEUSPESNO

		return sending;
	}

	public List<AdvertisementCreationDTO> findAllByIds(ArrayList<Long> ids) {
		List<Advertisement> advertisements = advertisementRepository.findAll();
		List<AdvertisementCreationDTO> sending = new ArrayList<AdvertisementCreationDTO>();
		AdvertisementCreationDTO temp;

		for (Advertisement tempad : advertisements) {

			for (Long id : ids) {

				if (tempad.getId().equals(id)) {

					temp = new AdvertisementCreationDTO(tempad.getId(), tempad.getName(), tempad.getModel().getName(),
							tempad.getBrand().getName(), tempad.getFuelType().getName(),
							tempad.getTransmissionType().getName(), tempad.getCarClass().getName(),
							tempad.getTravelled(), tempad.getCarSeats(), tempad.getPrice(), tempad.getPostedByID(),
							tempad.getDiscount(), tempad.getPriceWithDiscount(), tempad.getPictures(),
							tempad.getGrade());

					sending.add(temp);
					break;
				}
			}

		}

		System.out.println("SALJEM TI OGLASA BR======================" + sending.size());

		return sending;
	}

	public Advertisement findOneByid(Long id) {
		Advertisement ad = advertisementRepository.findOneByid(id);

		ad.setGrade(gradeService.calculateGradeForAd(id));
		System.out.println(ad.getGrade());
		return advertisementRepository.findOneByid(id);
	}

	public Advertisement update(Advertisement advertisement) {
		return advertisementRepository.save(advertisement);
	}

	public List<AdvertisementCreationDTO> filterAds(FilterAdsDTO filterAdsDTO) {
		List<Advertisement> allAds = advertisementRepository.findAll();
		List<Advertisement> filteredAds = new ArrayList<Advertisement>();
		List<Advertisement> filteredAvailableAds = new ArrayList<Advertisement>();
		List<AdvertisementCreationDTO> filteredAdsDTOs = new ArrayList<AdvertisementCreationDTO>();

		List<BookingDTO> bookedTimes = restTemplate.exchange("http://book/getAllBookings", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<BookingDTO>>() {
				}).getBody();

		for (Advertisement ad : allAds) {
			if ((ad.getTransmissionType().getName().equals(filterAdsDTO.getTransmissionType())
					|| filterAdsDTO.getTransmissionType() == null
					|| filterAdsDTO.getTransmissionType().equals("Choose a gearshift type"))
					&& (ad.getFuelType().getName().equals(filterAdsDTO.getFuelType())
							|| filterAdsDTO.getFuelType() == null
							|| filterAdsDTO.getFuelType().equals("Choose a fuel type"))
					&& (ad.getCarClass().getName().equals(filterAdsDTO.getCarClass())
							|| filterAdsDTO.getCarClass() == null
							|| filterAdsDTO.getCarClass().equals("Choose a car class"))
					&& (ad.getBrand().getName().equals(filterAdsDTO.getBrand()) || filterAdsDTO.getBrand() == null
							|| filterAdsDTO.getBrand().equals("Choose a car brand"))
					&& (ad.getModel().getName().equals(filterAdsDTO.getModel()) || filterAdsDTO.getModel() == null
							|| filterAdsDTO.getModel().equals("Choose a car model"))
					&& (ad.getCarSeats() == filterAdsDTO.getCarSeats() || filterAdsDTO.getCarSeats() == 0)
					&& (ad.getTravelled() >= filterAdsDTO.getTravelledFrom() || filterAdsDTO.getTravelledFrom() == 0)
					&& (ad.getTravelled() <= filterAdsDTO.getTravelledTo() || filterAdsDTO.getTravelledTo() == 0)
					&& (ad.getPrice() >= filterAdsDTO.getPriceFrom() || filterAdsDTO.getPriceFrom() == 0)
					&& (ad.getPrice() <= filterAdsDTO.getPriceTo() || filterAdsDTO.getPriceTo() == 0)) {

				filteredAds.add(ad);
			}

		}

		int taken = 0;

		LocalDateTime timeFrom = filterAdsDTO.getTimeFrom();
		LocalDateTime timeTo = filterAdsDTO.getTimeTo();

		for (Advertisement ad : filteredAds) {
			taken = 0;
			if (filterAdsDTO.getTimeFrom() == null || filterAdsDTO.getTimeTo() == null) {
				return filteredAdsDTOs;
			} else {

				if ((timeFrom.isBefore(LocalDateTime.now().plusDays(2))
						|| timeTo.isBefore(LocalDateTime.now().plusDays(2))) || timeFrom.isAfter(timeTo)) {
					return filteredAdsDTOs;
				}
				for (BookingDTO bookingDTO : bookedTimes) {
					if (bookingDTO.getAdvertisementId() == ad.getId()) {

						if (timeFrom.isAfter(bookingDTO.getTimeFrom()) && timeFrom.isBefore(bookingDTO.getTimeTo())) {
							taken = 1;
						}

						if (timeTo.isAfter(bookingDTO.getTimeFrom()) && timeTo.isBefore(bookingDTO.getTimeTo())) {
							taken = 1;
						}

						if (bookingDTO.getTimeFrom().isAfter(timeFrom) && bookingDTO.getTimeFrom().isBefore(timeTo)) {
							taken = 1;
						}

						if (bookingDTO.getTimeTo().isAfter(timeFrom) && bookingDTO.getTimeTo().isBefore(timeTo)) {
							taken = 1;
						}
					}
				}

			}
			if (taken == 0) {
				filteredAvailableAds.add(ad);
			}
		}

		// KAD SE OTKOMENTARISE, VRACACE FILTEREDAVAILABLEADS

		AdvertisementCreationDTO temp;
		for (Advertisement ad : filteredAvailableAds) {
			temp = new AdvertisementCreationDTO(ad);
			filteredAdsDTOs.add(temp);
		}

		return filteredAdsDTOs;
	}

	public void saveCommentAndGrade(CommentDTO commentDTO){
	 	Advertisement ad = advertisementRepository.findOneByid(commentDTO.getAd());
	 	Grade grade = new Grade(commentDTO.getGrade(), ad); //OVDE TREBA DOBITI ENDUSERA PO ID

	 	gradeService.save(grade);

		EndUserNumberOfAdsDTO endUser = restTemplate.exchange("http://auth/getLoggedEndUser", HttpMethod.GET, null,
				new ParameterizedTypeReference<EndUserNumberOfAdsDTO>() {
				}).getBody();

	 	Date date = new Date();
	 	System.out.println(date);

		Comment comment = new Comment(commentDTO.getMessage(), date, ad,
	 	endUser.getId(), commentDTO.getGrade());
		comment.setApproved(false);
		comment.setDeleted(false);
	 	commentRepository.save(comment);
	}

	public AdvertisementCreationDTO findAdAndComments(Long id) {
		Advertisement ad = advertisementRepository.findOneByid(id); // OVA

		List<Comment> db = commentRepository.findByAd_Id(id);

		// //sredjivanje komentara
		List<CommentPreviewDTO> comments = new ArrayList<CommentPreviewDTO>();
		for(int i = 0;i < db.size();i++) {
			if(!db.get(i).getApproved()){
				continue;
			}
			
			HttpEntity<Long> request = new HttpEntity<>(db.get(i).getEndUserID());
			String email = 
			restTemplate.postForEntity("http://auth/getEmail", request,String.class, db.get(i).getEndUserID()).getBody();

			String commentValue;

			if(db.get(i).getDeleted() == true){
				commentValue = "Komentar je obrisan od strane administratora";
			}else {
				commentValue = db.get(i).getValue();
			}

			CommentPreviewDTO temp = new CommentPreviewDTO(commentValue,
			email,
			db.get(i).getGrade(), db.get(i).getDate());
			temp.setId(db.get(i).getId());

			if(db.get(i).getReply() != null) {
				request = new HttpEntity<>(db.get(i).getReply().getAgentID());
				String agentMail = restTemplate.postForEntity("http://auth/getAgentEmail", request,String.class, db.get(i).getReply().getAgentID()).getBody();


				ReplyDTO replyDTO = new ReplyDTO();
				replyDTO.setComment(db.get(i).getReply().getComment());
				replyDTO.setAgentMail(agentMail);

				temp.setReplyDTO(replyDTO);
			}
			System.out.println(temp);

			comments.add(temp);
		}

		AdvertisementCreationDTO adDTO = new AdvertisementCreationDTO(ad);

		adDTO.setGrade(gradeService.calculateGradeForAd(id));

		adDTO.setComments(comments);
		return adDTO;
	}

	public List<Advertisement> getAllByUser(Long id) {
		List<Advertisement> all = advertisementRepository.findAll();
		List<Advertisement> usersAds = new ArrayList<Advertisement>();
		for (Advertisement advertisement : all) {
			if (advertisement.getPostedByID().equals(id)) {
				usersAds.add(advertisement);
			}
		}
		return usersAds;
	}

	public List<AdvertisementCreationDTO> getAllByPostedBy(Long id) {
		// salje sa fronta id usera, ne id agenta, i zato ne prikazuje formu za reply
		HttpEntity<Long> request = new HttpEntity<>(id);
		Long agentID = restTemplate.postForEntity("http://auth/getAgentIDByUserID", request,Long.class, id).getBody();
		System.out.println("ID AGENTA? " + id);
		List<Advertisement> advertisements = advertisementRepository.findAllByPostedByID(agentID);
		List<AdvertisementCreationDTO> sending = new ArrayList<AdvertisementCreationDTO>();
		AdvertisementCreationDTO temp;
		for (int i = 0; i < advertisements.size(); i++) {
			advertisements.get(i).setGrade(gradeService.calculateGradeForAd(advertisements.get(i).getId()));
			Advertisement tempad = advertisements.get(i);

			temp = new AdvertisementCreationDTO(tempad.getId(), tempad.getName(), tempad.getModel().getName(),
					tempad.getBrand().getName(), tempad.getFuelType().getName(), tempad.getTransmissionType().getName(),
					tempad.getCarClass().getName(), tempad.getTravelled(), tempad.getCarSeats(), tempad.getPrice(),
					tempad.getPostedByID(), tempad.getDiscount(), tempad.getPriceWithDiscount(), tempad.getPictures(),
					tempad.getGrade());

			sending.add(temp);
		}
		return sending;
	}
	
	public void saveReply(ReplyDTO replyDTO){ 
		HttpEntity<String> request = new HttpEntity<>(replyDTO.getAgentMail());
		//Long agentID = restTemplate.postForEntity("http://auth/getAgentIDByMail", request, Long.class).getBody();
		Long agentID = restTemplate.exchange("http://auth/getAgentIDByMail", HttpMethod.POST, request, 
		new ParameterizedTypeReference<Long>() {
		}).getBody();
		
		Comment comment = commentRepository.findOneByid(replyDTO.getId());
		Reply reply = new Reply(replyDTO.getComment(), comment, agentID); 
		comment.setReply(reply); 
		replyRepository.save(reply);
		commentRepository.save(comment);
	} 

	public List<CommentPreviewDTO> getUnapprovedComments(){
		List<Comment> list = commentRepository.findByApproved(false);
		List<CommentPreviewDTO> comments = new ArrayList<>();

		String email;
		for (Comment temp : list) {
			HttpEntity<Long> request = new HttpEntity<>(temp.getEndUserID());
			email = restTemplate.postForEntity("http://auth/getEmail", request, String.class, temp.getEndUserID()).getBody();
			System.out.println("Email komentara: " + email);
			comments.add(new CommentPreviewDTO(temp.getId(), temp.getValue(), email, gradeService.calculateGradeForAd(temp.getId()), temp.getDate()));
		}

		return comments;
	}

	public void approveComment(Long id){
		Comment comment = commentRepository.findOneByid(id);

		comment.setApproved(true);
		commentRepository.save(comment);
	}

	public void deleteComment(Long id){
		Comment comment = commentRepository.findOneByid(id);

		comment.setApproved(true);
		comment.setDeleted(true);
		commentRepository.save(comment);
	}
}
