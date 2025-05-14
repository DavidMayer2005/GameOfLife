from PIL import Image
image = Image.open("74931.jpg")
bw_image = image.convert("L")
bw_image.show()
bw_image.save("bw_photo.jpg")
print("✅ Image converted to black and white and saved as 'bw_photo.jpg'!")