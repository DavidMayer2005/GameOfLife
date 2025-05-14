import os
from PIL import Image

# Print the current directory to confirm where Python is looking
print("Current directory:", os.getcwd())

try:
    # Attempt to open the image
    image = Image.open("74931.jpg")  # Make sure the file name matches exactly
    print("Image loaded successfully!")

    # Resize the image to 200x200
    resized = image.resize((200, 200))

    # Show the resized image
    resized.show()

    # Save it as a new file
    resized.save("resized_photo.jpg")

    print("✅ Image resized and saved!")

except Exception as e:
    print(f"❌ Error: {e}")