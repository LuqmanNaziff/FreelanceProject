import React from 'react'
import { BeardTrimming, Store, LowFade, Chairs, ShakeHands } from "../../assets/images";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

const images = [
    BeardTrimming,
    Store,
    LowFade,
    Chairs,
    ShakeHands
  ];

  const ImageSlider = () => {
    const settings = {
      dots: true,
      infinite: true,
      speed: 500,
      slidesToShow: 1,
      slidesToScroll: 1,
      autoplay: true,
      autoplaySpeed: 3000,
    };
  
    return (
      <div style={{ backgroundColor: '#E0D7C7', padding: '3px', borderRadius: '10px', boxShadow: '0 8px 8px rgba(0, 0, 0, 0.2)'}}>
      <Slider {...settings}>
        {images.map((image, index) => (
          <div  key={index}>
            <img src={image} alt={`Slide ${index + 1}`} style={{ width: '100%' }} />
          </div>
        ))}
      </Slider>
      </div>
    );
  };

export const ImgSlider = () => {
  return (
    <ImageSlider />
  )
}
